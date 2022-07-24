package cn.edu.ecnu;

import cn.edu.ecnu.differential_privacy.accuracy.metrics.distance_quantities.OneDimensionalWassersteinDistance;
import cn.edu.ecnu.differential_privacy.accuracy.metrics.distance_quantities.TwoDimensionalWassersteinDistance;
import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;
import edu.ecnu.dll.cpl.expection.CPLException;
import org.junit.Test;

import java.util.TreeMap;

public class WassersteinTest {
    @Test
    public void test1_OneDimensionalWasserstein() {
        double[] distributionA = new double[] {
                3, 2, 1, 4
        };
        double[] distributionB = new double[] {
                1, 2, 4, 3
        };
        double result = OneDimensionalWassersteinDistance.getWassersteinDistance(distributionA, distributionB);
        System.out.println(result);
    }

    @Test
    public void test1_TwoDimensionalWasserstein() throws CPLException {
        TreeMap<TwoDimensionalIntegerPoint, Double> distributionA = new TreeMap<>();
        distributionA.put(new TwoDimensionalIntegerPoint(1, 0), 3.0);
        distributionA.put(new TwoDimensionalIntegerPoint(2, 0), 2.0);
        distributionA.put(new TwoDimensionalIntegerPoint(3, 0), 1.0);
        distributionA.put(new TwoDimensionalIntegerPoint(4, 0), 4.0);

        TreeMap<TwoDimensionalIntegerPoint, Double> distributionB = new TreeMap<>();
        distributionB.put(new TwoDimensionalIntegerPoint(1, 0), 1.0);
        distributionB.put(new TwoDimensionalIntegerPoint(2, 0), 2.0);
        distributionB.put(new TwoDimensionalIntegerPoint(3, 0), 4.0);
        distributionB.put(new TwoDimensionalIntegerPoint(4, 0), 3.0);

        double result = TwoDimensionalWassersteinDistance.getWassersteinDistance(distributionA, distributionB, 1);
        System.out.println(result);
    }

    @Test
    public void test2_TwoDimensionalWasserstein() throws CPLException {
        TreeMap<TwoDimensionalIntegerPoint, Double> distributionA = new TreeMap<>();
        distributionA.put(new TwoDimensionalIntegerPoint(1, 0), 3.0);
        distributionA.put(new TwoDimensionalIntegerPoint(2, 0), 2.0);
        distributionA.put(new TwoDimensionalIntegerPoint(3, 0), 1.0);
        distributionA.put(new TwoDimensionalIntegerPoint(4, 0), 4.0);

        TreeMap<TwoDimensionalIntegerPoint, Double> distributionB = new TreeMap<>();
        distributionB.put(new TwoDimensionalIntegerPoint(1, 0), 1.0);
        distributionB.put(new TwoDimensionalIntegerPoint(2, 0), 2.0);
        distributionB.put(new TwoDimensionalIntegerPoint(3, 0), 4.0);
        distributionB.put(new TwoDimensionalIntegerPoint(4, 0), 3.0);

        double result = TwoDimensionalWassersteinDistance.getWassersteinDistance(distributionA, distributionB, 2);
        System.out.println(result);
    }



}
