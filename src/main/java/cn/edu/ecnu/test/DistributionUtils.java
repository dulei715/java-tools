package cn.edu.ecnu.test;

import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class DistributionUtils {
    public static TreeMap<TwoDimensionalIntegerPoint, Double> generateTwoDimensionalIntegerDistribution(Double[][] distribution) {
        TwoDimensionalIntegerPoint tempPoint;
        TreeMap result = new TreeMap();
        for (int i = 0; i < distribution.length; i++) {
            for (int j = 0; j < distribution[i].length; j++) {
                result.put(new TwoDimensionalIntegerPoint(i, j), distribution[i][j]);
            }
        }
        return result;
    }

    public static List<List<String>> generateIndexAndValueStringList(Double[][] distribution) {
        List<List<String>> result = new ArrayList<>();
        List<String> tempList;
        for (int i = 0; i < distribution.length; i++) {
            for (int j = 0; j < distribution[i].length; j++) {
                tempList = new ArrayList<>();
                tempList.add(i+"");
                tempList.add(j+"");
                tempList.add(distribution[i][j]+"");
                result.add(tempList);
            }
        }
        return result;
    }
}
