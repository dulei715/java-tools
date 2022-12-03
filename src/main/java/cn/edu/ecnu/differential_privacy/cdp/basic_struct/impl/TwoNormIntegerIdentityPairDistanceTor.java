package cn.edu.ecnu.differential_privacy.cdp.basic_struct.impl;

import cn.edu.ecnu.differential_privacy.cdp.basic_struct.DistanceTor;
import cn.edu.ecnu.struct.pair.IdentityPair;

public class TwoNormIntegerIdentityPairDistanceTor implements DistanceTor<IdentityPair<Integer>> {

    @Override
    public double getDistance(IdentityPair<Integer> elemA, IdentityPair<Integer> elemB) {

        return Math.sqrt(Math.pow(elemA.getKey() - elemB.getKey(), 2) + Math.pow(elemA.getValue() - elemB.getValue(), 2));
    }
}
