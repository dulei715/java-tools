package cn.edu.ecnu.comparator;

import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;

import java.util.Comparator;

public class TwoDimensionalIntegerPointComparator implements Comparator<TwoDimensionalIntegerPoint> {
    @Override
    public int compare(TwoDimensionalIntegerPoint elemA, TwoDimensionalIntegerPoint elemB) {
        return elemA.compareTo(elemB);
    }
}
