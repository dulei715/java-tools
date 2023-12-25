package cn.edu.dll.math.linearfunction;

import cn.edu.dll.io.print.MyPrint;

import java.util.*;

/**
 * 用于处理整体单调递减函数，存在跳跃间断点，可向上跳跃
 */
public class MonotoneDecreaseLinearFittingWithRightPriority {
    private TreeMap<Double, Double> xToYMap = null;
    private TreeMap<Double, Double> yToXMap = null;

    public MonotoneDecreaseLinearFittingWithRightPriority(double[] xArray, double[] yArray) {
        this.xToYMap = new TreeMap<>();
        int len = xArray.length;
        if (yArray.length != len) {
            throw new RuntimeException("The lengths of two arrays are not equal!");
        }
        for (int i = 0; i < len; i++) {
            this.xToYMap.put(xArray[i], yArray[i]);
        }
        List<Map.Entry<Double, Double>> list = new ArrayList<>(this.xToYMap.entrySet());
        this.yToXMap = new TreeMap<>();
        Map.Entry<Double, Double> tempEntry;
        Double tempY;
        Double maxY = xToYMap.lastEntry().getValue();
        Double maxXForY = xToYMap.lastEntry().getKey();
        this.yToXMap.put(maxY, maxXForY);
        for (int i = len - 1; i >= 0; i--) {
            tempEntry = list.get(i);
            tempY = tempEntry.getValue();
            if (tempY <= maxY) {
                continue;
            }
            maxY = tempY;
            maxXForY = tempEntry.getKey();
            this.yToXMap.put(maxY, maxXForY);
        }
    }

    public TreeMap<Double, Double> getxToYMap() {
        return xToYMap;
    }

    public TreeMap<Double, Double> getyToXMap() {
        return yToXMap;
    }

    public Double getYByX(Double xValue) {
        return null;
    }

    public Double getXByY(Double yValue) {
        return null;
    }

    public static void main(String[] args) {
        double[] xArray = new double[]{1, 2, 3, 4, 5, 6};
        double[] yArray = new double[]{7, 6, 5, 6, 5, 4};
        MonotoneDecreaseLinearFittingWithRightPriority fitting = new MonotoneDecreaseLinearFittingWithRightPriority(xArray, yArray);
        TreeMap<Double, Double> xToYMap = fitting.getxToYMap();
        TreeMap<Double, Double> yToXMap = fitting.getyToXMap();
        MyPrint.showMap(xToYMap);
        MyPrint.showSplitLine("*", 150);
        MyPrint.showMap(yToXMap);
    }

}
