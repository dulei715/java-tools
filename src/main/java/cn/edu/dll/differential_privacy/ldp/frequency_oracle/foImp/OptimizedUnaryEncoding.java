package cn.edu.dll.differential_privacy.ldp.frequency_oracle.foImp;

import cn.edu.dll.basic.BasicArrayUtil;
import cn.edu.dll.basic.RandomUtil;
import cn.edu.dll.constant_values.ConstantValues;
import cn.edu.dll.differential_privacy.ldp.frequency_oracle.FrequencyOracle;
import cn.edu.dll.io.print.MyPrint;
import cn.edu.dll.struct.OneHot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class OptimizedUnaryEncoding implements FrequencyOracle<OneHot, OneHot> {

    private double epsilon;
    private int size;
    private double q;
    private Random random;

    public OptimizedUnaryEncoding(double epsilon) {
        this.epsilon = epsilon;
        this.q = 1.0 / (Math.exp(epsilon)+1);
        this.random = new Random();
    }

    @Override
    public OneHot perturb(OneHot rawData) {
        boolean[] data = rawData.getData();
        boolean[] resultData = new boolean[data.length];
        double probability;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == OneHot.ONE) {
                probability = 0.5;
            } else {
                probability = q;
            }
            resultData[i] = RandomUtil.isChosen(probability) ? OneHot.ONE : OneHot.ZERO;
        }
        return new OneHot(resultData);
    }

    @Override
    public double aggregate(int targetNoiseEstimateCount, int userSize) {
        return (targetNoiseEstimateCount - userSize * this.q) / (0.5 - this.q);
    }

    public static int[] count(Collection<OneHot> dataCollection) {
        int colSize = dataCollection.iterator().next().getDataLength();
        int[] result = new int[colSize];
        boolean[] tempOneHot;
        BasicArrayUtil.setIntArrayToZero(result);
        for (OneHot oneHot : dataCollection) {
            tempOneHot = oneHot.getData();
            for (int i = 0; i < colSize; i++) {
                result[i] += tempOneHot[i] ? 1 : 0;
            }
        }
        return result;
    }

    public double[] unbias(int[] perturbedCount, int userSize) {
        double[] result = new double[perturbedCount.length];
        for (int i = 0; i < perturbedCount.length; i++) {
            result[i] = this.aggregate(perturbedCount[i], userSize);
        }
        return result;
    }

    public static void main(String[] args) {
        double epsilon = 100;
        OptimizedUnaryEncoding oue = new OptimizedUnaryEncoding(epsilon);
        OneHot[] dataArray = new OneHot[]{
                new OneHot(OneHot.ONE, OneHot.ZERO, OneHot.ZERO, OneHot.ZERO, OneHot.ZERO),
                new OneHot(OneHot.ZERO, OneHot.ONE, OneHot.ZERO, OneHot.ZERO, OneHot.ZERO),
                new OneHot(OneHot.ZERO, OneHot.ZERO, OneHot.ONE, OneHot.ZERO, OneHot.ZERO),
                new OneHot(OneHot.ZERO, OneHot.ZERO, OneHot.ZERO, OneHot.ONE, OneHot.ZERO),
                new OneHot(OneHot.ZERO, OneHot.ZERO, OneHot.ZERO, OneHot.ZERO, OneHot.ONE),
        };
        MyPrint.showArray(dataArray);
        MyPrint.showSplitLine("*", 150);
        List<OneHot> disturbedData = new ArrayList<>(dataArray.length);
        for (int i = 0; i < dataArray.length; i++) {
            disturbedData.add(oue.perturb(dataArray[i]));
        }
        MyPrint.showList(disturbedData, ConstantValues.LINE_SPLIT);
        MyPrint.showSplitLine("*", 150);
        int[] disturbedCount = OptimizedUnaryEncoding.count(disturbedData);
        MyPrint.showIntegerArray(disturbedCount);
        MyPrint.showSplitLine("*", 150);
        double[] unbiasCount = oue.unbias(disturbedCount, disturbedData.size());
        MyPrint.showDoubleArray(unbiasCount);

    }
}
