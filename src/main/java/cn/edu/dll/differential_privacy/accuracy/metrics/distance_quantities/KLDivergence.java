package cn.edu.dll.differential_privacy.accuracy.metrics.distance_quantities;

import cn.edu.dll.struct.point.TwoDimensionalIntegerPoint;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class KLDivergence {
    /**
     *  要求输入的两个分布的Key完全一致
     * @param distributionA
     * @param distributionB
     * @param minimalDenominator 最小的分母。要求计算KL散度时，每个概率加上这个精度。当改参数小于0时，不考虑加上这个最小分母
     * @return the relative entropy (KL divergence): KL(distributionA || distributionB)
     */
    public static double getKLDivergence(TreeMap<TwoDimensionalIntegerPoint, Double> distributionA, TreeMap<TwoDimensionalIntegerPoint, Double> distributionB, double minimalDenominator) {
        int sizeA = distributionA.size();
        int sizeB = distributionB.size();
        if (minimalDenominator < 0) {
            minimalDenominator = 0;
        }
        if (sizeB != sizeA) {
            throw new RuntimeException("The size of the two distributions are not equal!");
        }
        double result = 0;
        Iterator<Map.Entry<TwoDimensionalIntegerPoint, Double>> entrySetIteratorA = distributionA.entrySet().iterator();
        Iterator<Map.Entry<TwoDimensionalIntegerPoint, Double>> entrySetIteratorB = distributionB.entrySet().iterator();
        Double tempValueA, tempValueB;

        while(entrySetIteratorA.hasNext()) {
            tempValueA = entrySetIteratorA.next().getValue() + minimalDenominator;
            tempValueB = entrySetIteratorB.next().getValue() + minimalDenominator;
            result += tempValueA * Math.log(tempValueA / tempValueB);
        }
        return result;
    }
}
