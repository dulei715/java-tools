package cn.edu.dll.comparator;

import cn.edu.dll.struct.point.TwoDimensionalIntegerPoint;

import java.util.Comparator;

public class TwoDimensionalIntegerPointComparator implements Comparator<TwoDimensionalIntegerPoint> {
    @Override
    public int compare(TwoDimensionalIntegerPoint elemA, TwoDimensionalIntegerPoint elemB) {
        return elemA.compareTo(elemB);
    }
}
