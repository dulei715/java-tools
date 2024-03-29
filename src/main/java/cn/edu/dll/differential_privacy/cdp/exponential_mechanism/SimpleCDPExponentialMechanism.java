package cn.edu.dll.differential_privacy.cdp.exponential_mechanism;

import cn.edu.dll.differential_privacy.cdp.exponential_mechanism.utility.UtilityFunction;
import cn.edu.dll.differential_privacy.cdp.basic_struct.NeighborAble;

import java.util.List;

public class SimpleCDPExponentialMechanism<X extends NeighborAble<X>, R> extends ExponentialMechanism<X, R> {
    public SimpleCDPExponentialMechanism(UtilityFunction utilityFunction, Double epsilon, List inputList, List outputList) {
        super(utilityFunction, epsilon, inputList, outputList);
    }

    @Override
    protected void setDeltaU() {
        super.deltaU = -1.0;
        X inputElementA, inputElementB;
        R outputElement;
        double differ;
        double utilityValueA, utilityValueB;
        for (int i = 0; i < super.outputList.size(); i++) {
            outputElement = super.outputList.get(i);
            for (int j = 0; j < super.inputList.size(); j++) {
                inputElementA = super.inputList.get(j);
                utilityValueA = super.utilityFunction.getUtilityValue(inputElementA, outputElement);
                for (int k = j + 1; k < super.inputList.size(); k++) {
                    inputElementB = super.inputList.get(k);
                    if (inputElementA.isNeighborhoodWith(inputElementB)){
                        utilityValueB = super.utilityFunction.getUtilityValue(inputElementB, outputElement);
                        differ = Math.abs(utilityValueA - utilityValueB);
                        if (differ > super.deltaU) {
                            super.deltaU = differ;
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void setProbabilityConstant() {
        // exp(ε/(2△u))
        super.probabilityConstant = Math.exp(super.epsilon / (2 * super.deltaU));
    }
}
