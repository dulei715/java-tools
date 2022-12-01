package cn.edu.ecnu.differential_privacy.cdp.basic_struct.impl;

import cn.edu.ecnu.differential_privacy.cdp.basic_struct.DistanceTor;
import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;

public class TwoNormTwoDimensionalIntegerPointDistanceTor implements DistanceTor<TwoDimensionalIntegerPoint> {

    @Override
    public double getDistance(TwoDimensionalIntegerPoint elemA, TwoDimensionalIntegerPoint elemB) {
        TwoDimensionalIntegerPoint composedElem = TwoDimensionalIntegerPoint.integerLinearCompose(elemA, 1, elemB, -1);
        return Math.sqrt(Math.pow(composedElem.getXIndex(), 2) + Math.pow(composedElem.getYIndex(), 2));
    }
}
