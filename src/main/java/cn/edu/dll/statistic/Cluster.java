package cn.edu.dll.statistic;

import cn.edu.dll.map.MapUtils;
import cn.edu.dll.struct.pair.BasicPair;
import cn.edu.dll.basic.BasicCalculation;
import cn.edu.dll.basic.RandomUtil;

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

    /**
     * 找出dataList的中心点（该中心点不一定是dataList里的点）
     * @param dataList
     * @return
     */
    private static BasicPair<Double, Double> getNewCentroid(List<BasicPair<Double, Double>> dataList) {
        Double averageX = 0D, averageY = 0D, tempDistance, minimalDistance = Double.MAX_VALUE;
        BasicPair<Double, Double> averageElement;

        for (BasicPair<Double, Double> tempElement : dataList) {
            averageX += tempElement.getKey();
            averageY += tempElement.getValue();
        }
        averageX /= dataList.size();
        averageY /= dataList.size();
        averageElement = new BasicPair<>(averageX, averageY);
        return averageElement;
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

    protected static BasicPair<Double, Double> getNearestPoint(BasicPair<Double, Double> tempElement, TreeSet<BasicPair<Double, Double>> centroidTreeSet) {
        Double tempMinimalDistance = Double.MAX_VALUE, tempDistance;
        BasicPair<Double, Double> chosenCentroid = null;
        for (BasicPair<Double, Double> tempCentroidElement : centroidTreeSet) {
            tempDistance = BasicCalculation.get2Norm(tempElement, tempCentroidElement);
            if (tempDistance < tempMinimalDistance) {
                tempMinimalDistance = tempDistance;
                chosenCentroid = tempCentroidElement;
            }
        }
        return chosenCentroid;
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
    private static Double getSumDistance(TreeSet<BasicPair<Double, Double>> centroidTreeSetA, TreeSet<BasicPair<Double, Double>> centroidTreeSetB) {
        Iterator<BasicPair<Double, Double>> iteratorA = centroidTreeSetA.iterator();
        Iterator<BasicPair<Double, Double>> iteratorB = centroidTreeSetB.iterator();
        BasicPair<Double, Double> pointA, pointB;
        Double distanceSum = 0D;
        while (iteratorA.hasNext()) {
            pointA = iteratorA.next();
            pointB = iteratorB.next();
            distanceSum += BasicCalculation.get2Norm(pointA, pointB);
        }
        return distanceSum;
    }

    public static List<Integer> kMeansToGivenPoints(Collection<BasicPair<Double, Double>> data, Integer typeSize, Double haltDifference) {
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
    public static List<Integer> kMeansToGivenPointsByGivenSpecificPoints(final List<BasicPair<Double, Double>> dataList, TreeSet<Integer> currentCentroidIndexTreeSet, Double haltDifference) {
        Double difference;
        Integer tempChosenCentroidIndex;
//        List<BasicPair<Double, Double>> dataList = new ArrayList<>(data);
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

    public static TreeSet<BasicPair<Double, Double>> getRandomBasicPairWithoutRepeat(final List<BasicPair<Double, Double>> data, Integer typeSize) {
        List<Integer> indexList = RandomUtil.getRandomIntegerArrayWithoutRepeat(0, data.size() - 1, typeSize);
        TreeSet<BasicPair<Double, Double>> result = new TreeSet<>();
        for (Integer index : indexList) {
            result.add(data.get(index));
        }
        return result;
    }

    public static List<BasicPair<Double, Double>> kMeansToNewPoints(final List<BasicPair<Double, Double>> dataList, Integer typeSize, Double haltDifference) {
        Double difference;
        BasicPair<Double, Double> tempChosenCentroid, tempPoint;
        TreeSet<BasicPair<Double, Double>> newCentroidTreeSet, oldCentroidTreeSet;
//        List<BasicPair<Double, Double>> dataList = new ArrayList<>(data);
//        TreeSet<Integer> newCentroidIndexTreeSet = new TreeSet<>(RandomUtil.getRandomIntegerArrayWithoutRepeat(0, data.size() - 1, typeSize));
        newCentroidTreeSet = getRandomBasicPairWithoutRepeat(dataList, typeSize);
//        TreeSet<Integer> oldCentroidIndexTreeSet;
        Map<BasicPair<Double, Double>, List<BasicPair<Double, Double>>> typeMap = new HashMap<>();
        do {
            typeMap.clear();
            // 1. 计算各个点到中心点的距离，并将其归在最近中心点的一类
            for (int i = 0; i < dataList.size(); i++) {
                tempPoint = dataList.get(i);
                tempChosenCentroid = getNearestPoint(tempPoint, newCentroidTreeSet);
                MapUtils.putInListValue(typeMap, tempChosenCentroid, tempPoint);
            }
            // 2. 在每个类别中，重新计算中心点
            oldCentroidTreeSet = newCentroidTreeSet;
            newCentroidTreeSet = new TreeSet<>();
            for (List<BasicPair<Double, Double>> valueList : typeMap.values()) {
                tempChosenCentroid = getNewCentroid(valueList);
                newCentroidTreeSet.add(tempChosenCentroid);
            }
            // 3. 计算各个中心点的变动量
            difference = getSumDistance(newCentroidTreeSet, oldCentroidTreeSet);
        } while (difference > haltDifference);
        return new ArrayList<>(newCentroidTreeSet);
    }
    public static List<BasicPair<Double, Double>> kMeansToNewPointsByGivenSpecificPoints(final List<BasicPair<Double, Double>> dataList, TreeSet<BasicPair<Double, Double>> currentCentroidTreeSet, Double haltDifference) {
        Double difference;
        BasicPair<Double, Double> tempChosenCentroid, tempPoint;
        TreeSet<BasicPair<Double, Double>> oldCentroidTreeSet;
        Map<BasicPair<Double, Double>, List<BasicPair<Double, Double>>> typeMap = new HashMap<>();
        do {
            typeMap.clear();
            // 1. 计算各个点到中心点的距离，并将其归在最近中心点的一类
            for (int i = 0; i < dataList.size(); i++) {
                tempPoint = dataList.get(i);
                tempChosenCentroid = getNearestPoint(tempPoint, currentCentroidTreeSet);
                MapUtils.putInListValue(typeMap, tempChosenCentroid, tempPoint);
            }
            // 2. 在每个类别中，重新计算中心点
            oldCentroidTreeSet = currentCentroidTreeSet;
            currentCentroidTreeSet = new TreeSet<>();
            for (List<BasicPair<Double, Double>> valueList : typeMap.values()) {
                tempChosenCentroid = getNewCentroid(valueList);
                currentCentroidTreeSet.add(tempChosenCentroid);
            }
            // 3. 计算各个中心点的变动量
            difference = getSumDistance(currentCentroidTreeSet, oldCentroidTreeSet);
        } while (difference > haltDifference);
        return new ArrayList<>(currentCentroidTreeSet);
    }


}
