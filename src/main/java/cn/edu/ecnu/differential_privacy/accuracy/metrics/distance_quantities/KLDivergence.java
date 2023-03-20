package cn.edu.ecnu.differential_privacy.accuracy.metrics.distance_quantities;

import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class KLDivergence {
    /**
     *  要求输入的两个分布的Key完全一致
     * @param distributionA
     * @param distributionB
     * @return the relative entropy (KL divergence): KL(distributionA || distributionB)
     */
    public static double getKLDivergence(TreeMap<TwoDimensionalIntegerPoint, Double> distributionA, TreeMap<TwoDimensionalIntegerPoint, Double> distributionB) {
        int sizeA = distributionA.size();
        int sizeB = distributionB.size();
        if (sizeB != sizeA) {
            throw new RuntimeException("The size of the two distributions are not equal!");
        }
        double result = 0;
        Iterator<Map.Entry<TwoDimensionalIntegerPoint, Double>> entrySetIteratorA = distributionA.entrySet().iterator();
        Iterator<Map.Entry<TwoDimensionalIntegerPoint, Double>> entrySetIteratorB = distributionB.entrySet().iterator();
        Double tempValueA, tempValueB;

        while(entrySetIteratorA.hasNext()) {
            tempValueA = entrySetIteratorA.next().getValue();
            tempValueB = entrySetIteratorB.next().getValue();
            result += tempValueA * Math.log(tempValueA / tempValueB);
        }
        return result;
    }
}
