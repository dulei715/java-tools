package cn.edu.dll.differential_privacy.ldp.frequency_oracle.foImp;

import cn.edu.dll.basic.BasicArrayUtil;
import cn.edu.dll.basic.RandomUtil;
import cn.edu.dll.constant_values.ConstantValues;
import cn.edu.dll.differential_privacy.ldp.frequency_oracle.FrequencyOracle;
import cn.edu.dll.io.print.MyPrint;
import cn.edu.dll.struct.one_hot.OneHot;
import cn.edu.dll.struct.one_hot.SimpleIntegerOneHot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class OptimizedUnaryEncoding<T> implements FrequencyOracle<OneHot<T>, OneHot<T>> {

//    private double epsilon;
//    private int size;
    private double q;
//    private Random random;
//    private OneHot<T> oneHot;

    public OptimizedUnaryEncoding(double epsilon) {
//        this.epsilon = epsilon;
        this.q = 1.0 / (Math.exp(epsilon)+1);
//        this.random = new Random();
//        this.oneHot = oneHot;
    }

    public void resetEpsilon(double epsilon) {
        this.q = 1.0 / (Math.exp(epsilon)+1);
    }

    @Override
    public OneHot<T> perturb(OneHot<T> rawData) {
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
        return rawData.getInstance(resultData);
    }

    @Override
    public double aggregate(int targetNoiseEstimateCount, int userSize) {
        return (targetNoiseEstimateCount - userSize * this.q) / (0.5 - this.q);
    }

    public static <T> Integer[] count(Collection<OneHot<T>> dataCollection) {
        int colSize = dataCollection.iterator().next().getAreaSize();
        Integer[] result = new Integer[colSize];
        boolean[] tempOneHot;
        BasicArrayUtil.setIntArrayToZero(result);
        for (OneHot<T> oneHot : dataCollection) {
            tempOneHot = oneHot.getData();
            for (int i = 0; i < colSize; i++) {
                result[i] += tempOneHot[i] ? 1 : 0;
            }
        }
        return result;
    }
    public static <T> Integer[] countMultiple(Collection<List<OneHot<T>>> dataListCollection) {
        int colSize = dataListCollection.iterator().next().get(0).getAreaSize();
        Integer[] result = new Integer[colSize];
        boolean[] tempOneHot;
        BasicArrayUtil.setIntArrayToZero(result);
        for (List<OneHot<T>> dataList : dataListCollection) {
            for (OneHot<T> oneHot : dataList) {
                tempOneHot = oneHot.getData();
                for (int i = 0; i < colSize; i++) {
                    result[i] += tempOneHot[i] ? 1 : 0;
                }
            }
        }
        return result;
    }

    public Double[] unbias(Integer[] perturbedCount, int userSize) {
        Double[] result = new Double[perturbedCount.length];
        for (int i = 0; i < perturbedCount.length; i++) {
            result[i] = this.aggregate(perturbedCount[i], userSize);
        }
        return result;
    }

    public double getQ() {
        return q;
    }

    public static void main(String[] args) {
        double epsilon = 0.5;
        OneHot<Integer> oneHotBasic = new SimpleIntegerOneHot(5);
        OptimizedUnaryEncoding oue = new OptimizedUnaryEncoding(epsilon);
        OneHot<Integer>[] dataArray = new OneHot[5];
        for (int i = 0; i < dataArray.length; i++) {
            dataArray[i] = new SimpleIntegerOneHot(5);
        }
        for (int i = 0; i < dataArray.length; i++) {
            dataArray[i].setElement(i);
        }
        MyPrint.showArray(dataArray);
        MyPrint.showSplitLine("*", 150);
        List<OneHot<Integer>> disturbedData = new ArrayList<>(dataArray.length);
        for (int i = 0; i < dataArray.length; i++) {
            disturbedData.add(oue.perturb(dataArray[i]));
        }
        MyPrint.showList(disturbedData, ConstantValues.LINE_SPLIT);
        MyPrint.showSplitLine("*", 150);
        Integer[] disturbedCount = OptimizedUnaryEncoding.count(disturbedData);
        MyPrint.showIntegerArray(disturbedCount);
        MyPrint.showSplitLine("*", 150);
        Double[] unbiasCount = oue.unbias(disturbedCount, disturbedData.size());
        MyPrint.showDoubleArray(unbiasCount);

    }
}
