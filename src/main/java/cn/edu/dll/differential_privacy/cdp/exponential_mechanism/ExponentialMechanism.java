package cn.edu.dll.differential_privacy.cdp.exponential_mechanism;

import cn.edu.dll.differential_privacy.cdp.exponential_mechanism.utility.UtilityFunction;
import cn.edu.dll.basic.BasicArrayUtil;
import cn.edu.dll.basic.RandomUtil;

import java.util.List;

public abstract class ExponentialMechanism<X, R> {
    protected UtilityFunction<X, R> utilityFunction = null;
    protected Double deltaU = null;
    protected Double epsilon;

    // 用于方便计算：通常情况下为 exp(ε/(2△u)). 如果是PEM方案则为 exp(ε/△u)
    protected Double probabilityConstant = null;

    // 记录每个inputElement(行)对应的outputElement(列)的累积概率
    protected Double[][] cumulationProbabilityMatrix = null;

    protected List<X> inputList = null;
    protected List<R> outputList = null;

    // 记录每个inputElement对应的所有输出的和
    protected Double[] moleculeSum = null;


    protected abstract void setDeltaU();
    protected abstract void setProbabilityConstant();
    protected Double getProbabilityMolecule(X inputElement, R outputElement) {
        Double utilityValue = this.utilityFunction.getUtilityValue(inputElement, outputElement);
        return Math.pow(this.probabilityConstant, utilityValue);
    }

    protected void setMoleculeSumAndCumulationProbabilityMatrix() {
        X inputElement;
        R outputElement;
        Double[][] probabilityMoleculeMatrix = new Double[this.inputList.size()][this.outputList.size()];
        for (int i = 0; i < probabilityMoleculeMatrix.length; i++) {
            inputElement = this.inputList.get(i);
            for (int j = 0; j < probabilityMoleculeMatrix[0].length; j++) {
                outputElement = this.outputList.get(j);
                probabilityMoleculeMatrix[i][j] = this.getProbabilityMolecule(inputElement, outputElement);
            }
        }
        this.cumulationProbabilityMatrix = new Double[this.inputList.size()][this.outputList.size()];
        this.moleculeSum = new Double[this.cumulationProbabilityMatrix.length];
        for (int i = 0; i < this.cumulationProbabilityMatrix.length; i++) {
            this.moleculeSum[i] = BasicArrayUtil.getSum(probabilityMoleculeMatrix[i]);
            this.cumulationProbabilityMatrix[i][0] = 0.0;
            for (int j = 1; j < this.cumulationProbabilityMatrix[0].length; j++) {
                // cumulationProbabilityMatrix的第n列记录的是输出第0到第n-1个输出元素的累计概率
                this.cumulationProbabilityMatrix[i][j] = this.cumulationProbabilityMatrix[i][j-1] + probabilityMoleculeMatrix[i][j-1] / this.moleculeSum[i];
            }
        }
    }

    public ExponentialMechanism(UtilityFunction<X, R> utilityFunction, Double epsilon, List<X> inputList, List<R> outputList) {
        this.utilityFunction = utilityFunction;
        this.epsilon = epsilon;
        this.inputList = inputList;
        this.outputList = outputList;

        this.setDeltaU();
        this.setProbabilityConstant();
        this.setMoleculeSumAndCumulationProbabilityMatrix();
    }

    protected R disturbByGivingInputIndex(int index) {
        Integer outputElementIndex = RandomUtil.getRandomIndexGivenCumulatedPoint(this.cumulationProbabilityMatrix[index]);
        return this.outputList.get(outputElementIndex);
    }

    public R disturb(X inputElement) {
        int inputElementIndex = BasicArrayUtil.getFirstFindValueIndex(this.inputList, inputElement);
        return this.disturbByGivingInputIndex(inputElementIndex);
    }




}
