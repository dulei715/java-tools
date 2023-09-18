package cn.edu.ecnu.statistic;

import cn.edu.ecnu.basic.BasicCalculation;
import cn.edu.ecnu.basic.RandomUtil;
import cn.edu.ecnu.differential_privacy.cdp.basic_struct.DistanceAble;
import cn.edu.ecnu.differential_privacy.cdp.basic_struct.DistanceTor;
import cn.edu.ecnu.map.MapUtils;
import cn.edu.ecnu.struct.pair.BasicPair;

import java.util.*;

public class Cluster {

    /**
     * 找出dataIndexList中索引对应的dataList中的点的中心点
     * 该方法用的是平均值法，可以修改成其他方法（如：最小二乘求最短距离）
     * @param dataList
     * @param dataIndexList
     * @return
     */
    private static Integer getNewCentroidIndex(List<BasicPair<Double, Double>> dataList, List<Integer> dataIndexList) {
        Double averageX = 0D, averageY = 0D, tempDistance, minimalDistance = Double.MAX_VALUE;
        BasicPair<Double, Double> tempElement, averageElement;
        Integer averageElementIndex = -1;

        for (Integer dataIndex : dataIndexList) {
            tempElement = dataList.get(dataIndex);
            averageX += tempElement.getKey();
            averageY += tempElement.getValue();
        }
        averageX /= dataIndexList.size();
        averageY /= dataIndexList.size();
        averageElement = new BasicPair<>(averageX, averageY);
        for (Integer dataIndex : dataIndexList) {
            tempElement = dataList.get(dataIndex);
            tempDistance = BasicCalculation.get2Norm(tempElement, averageElement);
            if (tempDistance < minimalDistance) {
                minimalDistance = tempDistance;
                averageElementIndex = dataIndex;
            }
        }
        return averageElementIndex;
    }

    private static Integer getNearestPointIndex(List<BasicPair<Double, Double>> dataList, Integer elementIndex, TreeSet<Integer> centroidIndexTreeSet) {
        BasicPair<Double, Double> tempElement = dataList.get(elementIndex), tempCentroidElement;
        Double tempMinimalDistance = Double.MAX_VALUE, tempDistance;
        Integer chosenCentroidIndex = -1;
        for (Integer centroidIndex : centroidIndexTreeSet) {
            tempCentroidElement = dataList.get(centroidIndex);
            tempDistance = BasicCalculation.get2Norm(tempElement, tempCentroidElement);
            if (tempDistance < tempMinimalDistance) {
                tempMinimalDistance = tempDistance;
                chosenCentroidIndex = centroidIndex;
            }
        }
        return chosenCentroidIndex;
    }

    private static Double getSumDistance(List<BasicPair<Double, Double>> dataList, TreeSet<Integer> centroidIndexTreeSetA, TreeSet<Integer> centroidIndexTreeSetB) {
        Iterator<Integer> iteratorA = centroidIndexTreeSetA.iterator();
        Iterator<Integer> iteratorB = centroidIndexTreeSetB.iterator();
        Integer indexA, indexB;
        BasicPair<Double, Double> elementA, elementB;
        Double distanceSum = 0D;
        while (iteratorA.hasNext()) {
            indexA = iteratorA.next();
            indexB = iteratorB.next();
            elementA = dataList.get(indexA);
            elementB = dataList.get(indexB);
            distanceSum += BasicCalculation.get2Norm(elementA, elementB);
        }
        return distanceSum;
    }

    public static List<Integer> kMeans(Collection<BasicPair<Double, Double>> data, Integer typeSize, Double haltDifference) {
        Double difference;
        Integer tempChosenCentroidIndex;
        List<BasicPair<Double, Double>> dataList = new ArrayList<>(data);
        TreeSet<Integer> newCentroidIndexTreeSet = new TreeSet<>(RandomUtil.getRandomIntegerArrayWithoutRepeat(0, data.size() - 1, typeSize));
        TreeSet<Integer> oldCentroidIndexTreeSet;
        Map<Integer, List<Integer>> typeMap = new HashMap<>();
        do {
            typeMap.clear();
            // 1. 计算各个点到中心点的距离，并将其归在最近中心点的一类
            for (int i = 0; i < dataList.size(); i++) {
                tempChosenCentroidIndex = getNearestPointIndex(dataList, i, newCentroidIndexTreeSet);
                MapUtils.putInListValue(typeMap, tempChosenCentroidIndex, i);
            }
            // 2. 在每个类别中，重新计算中心点
            oldCentroidIndexTreeSet = newCentroidIndexTreeSet;
            newCentroidIndexTreeSet = new TreeSet<>();
            for (List<Integer> valueList : typeMap.values()) {
                tempChosenCentroidIndex = getNewCentroidIndex(dataList, valueList);
                newCentroidIndexTreeSet.add(tempChosenCentroidIndex);
            }
            // 3. 计算各个中心点的变动量
            difference = getSumDistance(dataList, newCentroidIndexTreeSet, oldCentroidIndexTreeSet);
        } while (difference > haltDifference);
        return new ArrayList<>(newCentroidIndexTreeSet);
    }
    public static List<Integer> kMeansByGivenSpecificPoint(Collection<BasicPair<Double, Double>> data, TreeSet<Integer> currentCentroidIndexTreeSet, Double haltDifference) {
        Double difference;
        Integer tempChosenCentroidIndex;
        List<BasicPair<Double, Double>> dataList = new ArrayList<>(data);
//        TreeSet<Integer> newCentroidIndexTreeSet = new TreeSet<>(RandomUtil.getRandomIntegerArrayWithoutRepeat(0, data.size() - 1, typeSize));
        TreeSet<Integer> oldCentroidIndexTreeSet = null;
        Map<Integer, List<Integer>> typeMap = new HashMap<>();
        do {
            typeMap.clear();
            // 1. 计算各个点到中心点的距离，并将其归在最近中心点的一类
            for (int i = 0; i < dataList.size(); i++) {
                tempChosenCentroidIndex = getNearestPointIndex(dataList, i, currentCentroidIndexTreeSet);
                MapUtils.putInListValue(typeMap, tempChosenCentroidIndex, i);
            }
            // 2. 在每个类别中，重新计算中心点
            oldCentroidIndexTreeSet = currentCentroidIndexTreeSet;
            currentCentroidIndexTreeSet = new TreeSet<>();
            for (List<Integer> valueList : typeMap.values()) {
                tempChosenCentroidIndex = getNewCentroidIndex(dataList, valueList);
                currentCentroidIndexTreeSet.add(tempChosenCentroidIndex);
            }
            // 3. 计算各个中心点的变动量
            difference = getSumDistance(dataList, currentCentroidIndexTreeSet, oldCentroidIndexTreeSet);
        } while (difference > haltDifference);
        return new ArrayList<>(currentCentroidIndexTreeSet);
    }



}
