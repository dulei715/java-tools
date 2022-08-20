package cn.edu.ecnu.dataset;

import cn.edu.ecnu.struct.point.TwoDimensionalDoublePoint;

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
}
