package cn.edu.ecnu.struct.grid;


import cn.edu.ecnu.constant_values.ConstantValues;
import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.map.MapUtils;
import cn.edu.ecnu.struct.grid.Grid;
import cn.edu.ecnu.struct.grid.sub_struct.DistanceArrayAndSubsetMatrixStruct;
import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;
import com.google.common.collect.Sets;

import java.lang.reflect.Array;
import java.util.*;

public class IntegerSquareGrid extends Grid {
    public static Set<Integer> generateSet(Integer... arr) {
        return Sets.newHashSet(arr);
    }
    public static Set<TwoDimensionalIntegerPoint> generateSet(int gridLength) {
        List<TwoDimensionalIntegerPoint> squareGridList = Grid.generateTwoDimensionalIntegerPoint(gridLength, 0, 0);
        return Sets.newHashSet(squareGridList);
    }

    public static DistanceArrayAndSubsetMatrixStruct generateDistanceArrayAndSubsetMatrix(int gridLength) {
        Double[] distanceArray;
        Double tempDistanceA, tempDistanceB;
        List<TwoDimensionalIntegerPoint> integerPointList;
        Map<TwoDimensionalIntegerPoint, Map<Integer, Set<TwoDimensionalIntegerPoint>>> map;
        Integer tempPointIndexA, tempPointIndexB, tempDistanceIndex;

        integerPointList = Grid.generateTwoDimensionalIntegerPoint(gridLength, 0, 0);
        distanceArray = Grid.getDistinct2NormDistanceGivenIntegerSquareGridLength(gridLength);
//        MyPrint.showList(integerPointList, ConstantValues.LINE_SPLIT);
        map = new HashMap<>();
        TwoDimensionalIntegerPoint pointA, pointB, pointC;
        for (int i = 0; i < gridLength; i++) {
//            tempPointIndexA = i * gridLength + i;
//            pointA = integerPointList.get(tempPointIndexA);
//            for (int index = 0; index < integerPointList.size(); index++) {
//                pointC = integerPointList.get(index);
//                tempDistanceA = pointA.getDistance(pointC);
//                tempDistanceIndex = Arrays.binarySearch(distanceArray, tempDistanceA);
//                MapUtils.addMapAsValue(map, pointA, tempDistanceIndex, pointC);
//            }
            for (int j = i; j < gridLength; j++) {
                tempPointIndexA = i * gridLength + j;
                tempPointIndexB = j * gridLength + i;
                pointA = integerPointList.get(tempPointIndexA);
                pointB = integerPointList.get(tempPointIndexB);
                for (int index = 0; index < integerPointList.size(); index++) {
                    pointC = integerPointList.get(index);
                    tempDistanceA = pointA.getDistance(pointC);
                    tempDistanceIndex = Arrays.binarySearch(distanceArray, tempDistanceA);
                    MapUtils.addMapAsValue(map, pointA, tempDistanceIndex, pointC);
                    if (j != i) {
                        tempDistanceB = pointB.getDistance(pointC);
                        tempDistanceIndex = Arrays.binarySearch(distanceArray, tempDistanceB);
                        MapUtils.addMapAsValue(map, pointB, tempDistanceIndex, pointC);
                    }
                }
            }
        }
        return new DistanceArrayAndSubsetMatrixStruct(distanceArray, map);
    }

    public static void main(String[] args) {
        DistanceArrayAndSubsetMatrixStruct result = generateDistanceArrayAndSubsetMatrix(4);
        Double[] distanceArray = result.getDistanceArray();
        Map<TwoDimensionalIntegerPoint, Map<Integer, Set<TwoDimensionalIntegerPoint>>> matrix = result.getSubsetMatrix();
//        MyPrint.showArray(distanceArray);
        MyPrint.showMap(matrix);
    }

}
