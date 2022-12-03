package cn.edu.ecnu.differential_privacy.cdp.basic_struct.impl;

import cn.edu.ecnu.differential_privacy.cdp.basic_struct.DistanceTor;
import cn.edu.ecnu.struct.pair.IdentityPair;
import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;

public class OneNormIntegerIdentityPairDistanceTor implements DistanceTor<IdentityPair<Integer>> {

    @Override
    public double getDistance(IdentityPair<Integer> elemA, IdentityPair<Integer> elemB) {
        return Double.valueOf(Math.abs(elemA.getKey() - elemB.getKey()) + Math.abs(elemA.getValue() - elemB.getValue()));
    }
}
