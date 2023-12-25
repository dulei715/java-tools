package cn.edu.dll.differential_privacy.cdp.basic_struct.impl;

import cn.edu.dll.struct.point.TwoDimensionalIntegerPoint;
import cn.edu.dll.differential_privacy.cdp.basic_struct.DistanceTor;

public class OneNormTwoDimensionalIntegerPointDistanceTor implements DistanceTor<TwoDimensionalIntegerPoint> {


    @Override
    public double getDistance(TwoDimensionalIntegerPoint elemA, TwoDimensionalIntegerPoint elemB) {
        return Double.valueOf(Math.abs(elemA.getXIndex() - elemB.getXIndex()) + Math.abs(elemA.getYIndex() - elemB.getYIndex()));
    }
}
