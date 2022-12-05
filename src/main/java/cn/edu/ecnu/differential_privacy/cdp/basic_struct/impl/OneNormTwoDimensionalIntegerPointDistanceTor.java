package cn.edu.ecnu.differential_privacy.cdp.basic_struct.impl;

import cn.edu.ecnu.differential_privacy.cdp.basic_struct.DistanceTor;
import cn.edu.ecnu.struct.pair.IdentityPair;
import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;

public class OneNormTwoDimensionalIntegerPointDistanceTor implements DistanceTor<TwoDimensionalIntegerPoint> {


    @Override
    public double getDistance(TwoDimensionalIntegerPoint elemA, TwoDimensionalIntegerPoint elemB) {
        return Double.valueOf(Math.abs(elemA.getXIndex() - elemB.getXIndex()) + Math.abs(elemA.getYIndex() - elemB.getYIndex()));
    }
}
