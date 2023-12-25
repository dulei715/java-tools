package cn.edu.dll.struct.grid.sub_struct;

import cn.edu.dll.struct.point.TwoDimensionalIntegerPoint;

import java.util.Map;
import java.util.Set;

public class DistanceArrayAndSubsetMatrixStruct {
    private Double[] distanceArray = null;
    private Map<TwoDimensionalIntegerPoint, Map<Integer, Set<TwoDimensionalIntegerPoint>>> subsetMatrix = null;

    public DistanceArrayAndSubsetMatrixStruct(Double[] distanceArray, Map<TwoDimensionalIntegerPoint, Map<Integer, Set<TwoDimensionalIntegerPoint>>> subsetMatrix) {
        this.distanceArray = distanceArray;
        this.subsetMatrix = subsetMatrix;
    }

    public Double[] getDistanceArray() {
        return distanceArray;
    }

    public void setDistanceArray(Double[] distanceArray) {
        this.distanceArray = distanceArray;
    }

    public Map<TwoDimensionalIntegerPoint, Map<Integer, Set<TwoDimensionalIntegerPoint>>> getSubsetMatrix() {
        return subsetMatrix;
    }

    public void setSubsetMatrix(Map<TwoDimensionalIntegerPoint, Map<Integer, Set<TwoDimensionalIntegerPoint>>> subsetMatrix) {
        this.subsetMatrix = subsetMatrix;
    }
}
