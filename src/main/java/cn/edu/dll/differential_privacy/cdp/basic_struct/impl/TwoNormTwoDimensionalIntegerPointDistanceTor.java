package cn.edu.dll.differential_privacy.cdp.basic_struct.impl;

import cn.edu.dll.struct.point.TwoDimensionalIntegerPoint;
import cn.edu.dll.differential_privacy.cdp.basic_struct.DistanceTor;

public class TwoNormTwoDimensionalIntegerPointDistanceTor implements DistanceTor<TwoDimensionalIntegerPoint> {

    @Override
    public double getDistance(TwoDimensionalIntegerPoint elemA, TwoDimensionalIntegerPoint elemB) {
        TwoDimensionalIntegerPoint composedElem = TwoDimensionalIntegerPoint.integerLinearCompose(elemA, 1, elemB, -1);
        return Math.sqrt(Math.pow(composedElem.getXIndex(), 2) + Math.pow(composedElem.getYIndex(), 2));
    }
}
