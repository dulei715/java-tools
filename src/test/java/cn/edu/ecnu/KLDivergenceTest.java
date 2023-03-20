package cn.edu.ecnu;

import cn.edu.ecnu.differential_privacy.accuracy.metrics.distance_quantities.KLDivergence;
import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;
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

        double klB1 = KLDivergence.getKLDivergence(distributionA, distributionB1);
        double klB2 = KLDivergence.getKLDivergence(distributionA, distributionB2);

        System.out.println(klB1);
        System.out.println(klB2);
    }
}
