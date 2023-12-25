package cn.edu.ecnu.statistic;

import cn.edu.dll.constant_values.ConstantValues;
import cn.edu.dll.differential_privacy.accuracy.metrics.distance_quantities.KLDivergence;
import cn.edu.dll.struct.point.TwoDimensionalIntegerPoint;
import org.junit.Test;

import java.util.TreeMap;

public class KLDivergenceTest {
    @Test
    public void fun1() {
        TreeMap<TwoDimensionalIntegerPoint, Double> distributionA = new TreeMap<>();
        TreeMap<TwoDimensionalIntegerPoint, Double> distributionB1 = new TreeMap<>();
        TreeMap<TwoDimensionalIntegerPoint, Double> distributionB2 = new TreeMap<>();
        TwoDimensionalIntegerPoint tempPoint;

        tempPoint = new TwoDimensionalIntegerPoint(0, 0);
        distributionA.put(tempPoint, 0.5);
        distributionB1.put(tempPoint, 0.25);
        distributionB2.put(tempPoint, 0.125);

        tempPoint = new TwoDimensionalIntegerPoint(1, 1);
        distributionA.put(tempPoint, 0.5);
        distributionB1.put(tempPoint, 0.75);
        distributionB2.put(tempPoint, 0.875);

        double klB1 = KLDivergence.getKLDivergence(distributionA, distributionB1, -1);
        double klB2 = KLDivergence.getKLDivergence(distributionA, distributionB2, -1);

        System.out.println(klB1);
        System.out.println(klB2);

        double klB3 = KLDivergence.getKLDivergence(distributionA, distributionB1, ConstantValues.DOUBLE_PRECISION);
        double klB4 = KLDivergence.getKLDivergence(distributionA, distributionB2, ConstantValues.DOUBLE_PRECISION);

        System.out.println(klB3);
        System.out.println(klB4);
    }
}
