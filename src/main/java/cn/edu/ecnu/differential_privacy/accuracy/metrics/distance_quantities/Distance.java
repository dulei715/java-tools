package cn.edu.ecnu.differential_privacy.accuracy.metrics.distance_quantities;


import cn.edu.ecnu.basic.cumulate.CumulativeFunction;
import cn.edu.ecnu.differential_privacy.accuracy.metrics.distance_quantities.struct.MeanVarianceBean;
import cn.edu.ecnu.statistic.StatisticTool;
import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Distance {
    /**
     * Get L1 distance
     * @param dataA
     * @param dataB
     * @return
     */
    public static double getL1Distance(double[] dataA, double[] dataB) {
        double result = 0;
        for (int i = 0; i < dataA.length; i++) {
            result += Math.abs(dataA[i] - dataB[i]);
        }
        return result;
    }
    public static Double getL1Distance(Double[] dataA, Double[] dataB) {
        double result = 0;
        for (int i = 0; i < dataA.length; i++) {
            result += Math.abs(dataA[i] - dataB[i]);
        }
        return result;
    }

    /**
     * Get L2 distance
     * @param dataA
     * @param dataB
     * @return
     */
    public static double getL2Distance(double[] dataA, double[] dataB) {
        double result = 0;
        for (int i = 0; i < dataA.length; i++) {
            result += Math.pow(dataA[i] - dataB[i], 2);
        }
        return Math.sqrt(result);
    }
    public static Double getL2Distance(Double[] dataA, Double[] dataB) {
        double result = 0;
        for (int i = 0; i < dataA.length; i++) {
            result += Math.pow(dataA[i] - dataB[i], 2);
        }
        return Math.sqrt(result);
    }

    /**
     * Get KL divergence
     * @param dataA
     * @param dataB
     * @return
     */
    public static double getKLDivergence(double[] dataA, double[] dataB) {
        double result = 0;
        for (int i = 0; i < dataA.length; i++) {
            result += dataA[i] * Math.log(dataA[i]/dataB[i]);
        }
        return result;
    }
    public static Double getKLDivergence(Double[] dataA, Double[] dataB) {
        double result = 0;
        for (int i = 0; i < dataA.length; i++) {
            result += dataA[i] * Math.log(dataA[i]/dataB[i]);
        }
        return result;
    }



    /**
     * Get Kolmogorov-Smirnov distance
     * @param distributionDataA
     * @param distributionDataB
     * @param num
     * @return
     */
    public static double getKSDistance(double[] distributionDataA, double[] distributionDataB, int num) {
        double result = 0, temp;
        for (int i = 1; i <= num; i++) {
            temp = Math.abs(CumulativeFunction.getCumulativeFunctionValue(distributionDataA, i) - CumulativeFunction.getCumulativeFunctionValue(distributionDataB, i));
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }

    public static Double getKSDistance(Double[] distributionDataA, Double[] distributionDataB, int num) {
        double result = 0, temp;
        for (int i = 1; i <= num; i++) {
            temp = Math.abs(CumulativeFunction.getCumulativeFunctionValue(distributionDataA, i) - CumulativeFunction.getCumulativeFunctionValue(distributionDataB, i));
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }

    /**
     * @param distributionA
     * @param distributionB
     * @return
     */
    public static Double getAbsMeanDifference(TreeMap<TwoDimensionalIntegerPoint, Double> distributionA, TreeMap<TwoDimensionalIntegerPoint, Double> distributionB) {
        Double distributionAMean = StatisticTool.getMean(distributionA);
        Double distributionBMean = StatisticTool.getMean(distributionB);
        return Math.abs(distributionAMean - distributionBMean);
    }

    public static Double getAbsVarianceDifference(TreeMap<TwoDimensionalIntegerPoint, Double> distributionA, TreeMap<TwoDimensionalIntegerPoint, Double> distributionB) {
        Double distributionAVariance = StatisticTool.getVariance(distributionA);
        Double distributionBVariance = StatisticTool.getVariance(distributionB);
        return Math.abs(distributionAVariance - distributionBVariance);
    }




}
