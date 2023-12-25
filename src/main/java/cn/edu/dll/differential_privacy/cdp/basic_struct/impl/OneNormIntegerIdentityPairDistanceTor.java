package cn.edu.dll.differential_privacy.cdp.basic_struct.impl;

import cn.edu.dll.differential_privacy.cdp.basic_struct.DistanceTor;
import cn.edu.dll.struct.pair.IdentityPair;

public class OneNormIntegerIdentityPairDistanceTor implements DistanceTor<IdentityPair<Integer>> {

    @Override
    public double getDistance(IdentityPair<Integer> elemA, IdentityPair<Integer> elemB) {
        return Double.valueOf(Math.abs(elemA.getKey() - elemB.getKey()) + Math.abs(elemA.getValue() - elemB.getValue()));
    }
}
