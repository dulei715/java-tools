package cn.edu.dll.struct.point;


import cn.edu.dll.basic.BasicCalculation;
import cn.edu.dll.struct.pair.BasicPair;

import java.util.*;
import java.util.function.Function;

@SuppressWarnings("ALL")
public class TwoDimensionalDoublePointUtils {

    /**
     * 获取两个集合各个点之间的距离值的统计量（用于距离数据）
     * @param taskTwoDimensionalDoublePointList
     * @param workerTwoDimensionalDoublePointList
     * @param interval
     * @return
     */
    public static Map<Double, Integer> getDistanceStatisticDataFromNormData(List<TwoDimensionalDoublePoint> taskTwoDimensionalDoublePointList, List<TwoDimensionalDoublePoint> workerTwoDimensionalDoublePointList, double interval) {
        TreeMap<Double, Integer> countResultMap = new TreeMap<>();
        TwoDimensionalDoublePoint taskTwoDimensionalDoublePoint, workerTwoDimensionalDoublePoint;
        for (int i = 0; i < taskTwoDimensionalDoublePointList.size(); i++) {
            taskTwoDimensionalDoublePoint = taskTwoDimensionalDoublePointList.get(i);
            for (int j = 0; j < workerTwoDimensionalDoublePointList.size(); j++) {
                workerTwoDimensionalDoublePoint = workerTwoDimensionalDoublePointList.get(j);
                Double distance = BasicCalculation.get2Norm(taskTwoDimensionalDoublePoint.getIndex(), workerTwoDimensionalDoublePoint.getIndex());
                Double ceilDistance = Math.ceil(distance / interval);
                Double keyDistance = ceilDistance * interval;
                if (!countResultMap.containsKey(keyDistance)) {
                    countResultMap.put(keyDistance, 1);
                } else {
                    Integer value = countResultMap.get(keyDistance);
                    countResultMap.put(keyDistance, value + 1);
                }
            }
        }
        return countResultMap;
    }

    /**
     * 获取两个集合各个点之间的距离值的统计量（用于经纬度数据）
     * @param taskTwoDimensionalDoublePointList
     * @param workerTwoDimensionalDoublePointList
     * @param interval
     * @return
     */
    public static Map<Double, Integer> getDistanceStatisticDataFromLLData(List<TwoDimensionalDoublePoint> taskTwoDimensionalDoublePointList, List<TwoDimensionalDoublePoint> workerTwoDimensionalDoublePointList, double interval) {
        TreeMap<Double, Integer> countResultMap = new TreeMap<>();
        TwoDimensionalDoublePoint taskTwoDimensionalDoublePoint, workerTwoDimensionalDoublePoint;
        for (int i = 0; i < taskTwoDimensionalDoublePointList.size(); i++) {
            taskTwoDimensionalDoublePoint = taskTwoDimensionalDoublePointList.get(i);
            for (int j = 0; j < workerTwoDimensionalDoublePointList.size(); j++) {
                workerTwoDimensionalDoublePoint = workerTwoDimensionalDoublePointList.get(j);
//                Double distance = BasicCalculation.get2Norm(taskPoint.getIndex(), workerPoint.getIndex());
                Double distance = BasicCalculation.getDistanceFrom2LngLat(taskTwoDimensionalDoublePoint.getYIndex(), taskTwoDimensionalDoublePoint.getXIndex(), workerTwoDimensionalDoublePoint.getYIndex(), workerTwoDimensionalDoublePoint.getXIndex());
                Double ceilDistance = Math.ceil(distance / interval);
                Double keyDistance = ceilDistance * interval;
                if (!countResultMap.containsKey(keyDistance)) {
                    countResultMap.put(keyDistance, 1);
                } else {
                    Integer value = countResultMap.get(keyDistance);
                    countResultMap.put(keyDistance, value + 1);
                }
            }
        }
        return countResultMap;
    }


    public static Integer getEqualPointNumberBetweenTwoList(List<TwoDimensionalDoublePoint> taskTwoDimensionalDoublePointList, List<TwoDimensionalDoublePoint> workerTwoDimensionalDoublePointList) {
        TwoDimensionalDoublePoint taskTwoDimensionalDoublePoint, workerTwoDimensionalDoublePoint;
        int equalNumber = 0;
        for (int i = 0; i < taskTwoDimensionalDoublePointList.size(); i++) {
            taskTwoDimensionalDoublePoint = taskTwoDimensionalDoublePointList.get(i);
            for (int j = 0; j < workerTwoDimensionalDoublePointList.size(); j++) {
                workerTwoDimensionalDoublePoint = workerTwoDimensionalDoublePointList.get(j);
                if (taskTwoDimensionalDoublePoint.equals(workerTwoDimensionalDoublePoint)) {
                    ++ equalNumber;
                }
            }
        }
        return equalNumber;
    }

    public static List<Double> getXIndexList(List<TwoDimensionalDoublePoint> data) {
        List<Double> resultList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            resultList.add(data.get(i).getXIndex());
        }
        return resultList;
    }

    public static List<Double> getYIndexList(List<TwoDimensionalDoublePoint> data) {
        List<Double> resultList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            resultList.add(data.get(i).getYIndex());
        }
        return resultList;
    }

    public static List<TwoDimensionalDoublePoint> parsePoint(BasicPair<Double, Double>... points) {
        List<TwoDimensionalDoublePoint> result = new ArrayList<>();
        TwoDimensionalDoublePoint tempPoint;
        for (int i = 0; i < points.length; i++) {
            tempPoint = new TwoDimensionalDoublePoint(points[i].getKey(), points[i].getValue());
        }
        return result;
    }

    public static List<TwoDimensionalDoublePoint> parsePoint(List<BasicPair<Double, Double>> pointList) {
        List<TwoDimensionalDoublePoint> result = new ArrayList<>();
        TwoDimensionalDoublePoint tempPoint;
        BasicPair<Double, Double> tempBasicPair;
        for (int i = 0; i < pointList.size(); i++) {
            tempBasicPair = pointList.get(i);
            tempPoint = new TwoDimensionalDoublePoint(tempBasicPair.getKey(), tempBasicPair.getValue());
            result.add(tempPoint);
        }
        return result;
    }

    public static double[] getDirectVector(TwoDimensionalDoublePoint point, TwoDimensionalDoublePoint originalPoint) {
        return new double[]{point.getXIndex() - originalPoint.getXIndex(), point.getYIndex() - originalPoint.getYIndex()};
    }

    public static double getDirectAngle(TwoDimensionalDoublePoint point, TwoDimensionalDoublePoint originalPoint) {
        double[] directVector = getDirectVector(point, originalPoint);
        return Math.atan2(directVector[1], directVector[0]);
    }

    public static double get2NormDistance(TwoDimensionalDoublePoint pointA, TwoDimensionalDoublePoint pointB) {
        return BasicCalculation.get2Norm(pointA.getIndex(), pointB.getIndex());
    }

    public static BasicPair<TwoDimensionalDoublePoint, Double> getNearest2NormDistancePointInGivenCollection(TwoDimensionalDoublePoint targetPoint, Collection<TwoDimensionalDoublePoint> pointCollection) {
        Double resultDistance = Double.MAX_VALUE, tempDistance;
        TwoDimensionalDoublePoint resultPoint = null;
        for (TwoDimensionalDoublePoint currentPoint : pointCollection) {
            tempDistance = get2NormDistance(targetPoint, currentPoint);
            if (tempDistance < resultDistance) {
                resultDistance = tempDistance;
                resultPoint = currentPoint;
            }
        }
        return new BasicPair<>(resultPoint, resultDistance);
    }

    public static BasicPair<TwoDimensionalDoublePoint, Double> getLongestDistance(TwoDimensionalDoublePoint targetPoint, List<TwoDimensionalDoublePoint> pointCollection) {
        Double resultDistance = -1D, tempDistance;
        TwoDimensionalDoublePoint resultPoint = null;
        for (TwoDimensionalDoublePoint currentPoint : pointCollection) {
            tempDistance = get2NormDistance(targetPoint, currentPoint);
            if (tempDistance > resultDistance) {
                resultDistance = tempDistance;
                resultPoint = currentPoint;
            }
        }
        return new BasicPair<>(resultPoint, resultDistance);
    }

    public static List<TwoDimensionalDoublePoint> getPointSubCollectionInGiven2NormDistanceRange(List<TwoDimensionalDoublePoint> dataCollection, TwoDimensionalDoublePoint targetPoint, Double distanceFactor, Double distanceConst, Double lowerBoundDistance, Double upperBoundDistance) {
        List<TwoDimensionalDoublePoint> result = new ArrayList<>();
        Double tempDistance;
        for (TwoDimensionalDoublePoint element : dataCollection) {
            tempDistance = get2NormDistance(targetPoint, element) * distanceFactor + distanceConst;
            if (tempDistance >= lowerBoundDistance && tempDistance <= upperBoundDistance) {
                result.add(element);
            }
        }
        return result;
    }

    public static List<TwoDimensionalDoublePoint> toSimpleDoublePoint(List<TwoDimensionalIntegerPoint> integerTrajectory) {
        List<TwoDimensionalDoublePoint> result = new ArrayList<>(integerTrajectory.size());
        for (TwoDimensionalIntegerPoint integerPoint : integerTrajectory) {
            result.add(new TwoDimensionalDoublePoint(integerPoint.getXIndex()*1.0, integerPoint.getYIndex()*1.0));
        }
        return result;
    }

}
