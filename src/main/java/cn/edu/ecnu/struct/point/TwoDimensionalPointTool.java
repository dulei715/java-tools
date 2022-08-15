package cn.edu.ecnu.struct.point;


import cn.edu.ecnu.basic.BasicCalculation;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("ALL")
public class TwoDimensionalPointTool {

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


}
