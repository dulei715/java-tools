package cn.edu.dll.dataset;

import cn.edu.dll.struct.point.TwoDimensionalDoublePoint;

import java.util.ArrayList;
import java.util.List;

public class DatasetHandler {
    public static List<TwoDimensionalDoublePoint> extractDataPointInGivenSquareArea(List<TwoDimensionalDoublePoint> pointList, TwoDimensionalDoublePoint leftBottomPoint, Double xLength, Double yLength) {
        List<TwoDimensionalDoublePoint> extractPointList = new ArrayList<>();
        for (TwoDimensionalDoublePoint point : pointList) {
            if(point.inRange(leftBottomPoint, xLength, yLength)) {
                extractPointList.add(point);
            }
        }
        return extractPointList;
    }

    public static List<TwoDimensionalDoublePoint> extractDataPointGivenShrinkUnitAndOffset(List<TwoDimensionalDoublePoint> pointList, int shrinkUnit, int offset) {
        List<TwoDimensionalDoublePoint> extractPointList = new ArrayList<>();
        for (int i = offset; i < pointList.size(); i += shrinkUnit) {
            extractPointList.add(pointList.get(i));
        }
        return extractPointList;
    }
}
