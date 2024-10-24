package cn.edu.dll.collection;

import cn.edu.dll.differential_privacy.cdp.basic_struct.DistanceAble;

import java.util.Collection;
import java.util.List;

public class CollectionTools {
    public static <T extends DistanceAble<T>> Double getMinimalDistanceFromElementToCollection(T element, Collection<T> collection) {
        Double resultDistance = Double.MAX_VALUE;
        Double tempDistance;
        for (T judgeElement : collection) {
            tempDistance = element.getDistance(judgeElement);
            if (tempDistance < resultDistance) {
                resultDistance = tempDistance;
            }
        }
        return resultDistance;
    }

    public static Double getMinimalValue(Collection<Double> data) {
        double result = Double.MAX_VALUE;
        for (Double element : data) {
            if (element < result) {
                result = element;
            }
        }
        return result;
    }
    public static Double getMaximalValue(Collection<Double> data) {
        double result = data.iterator().next();
        for (Double element : data) {
            if (element < result) {
                result = element;
            }
        }
        return result;
    }

    /**
     * 获得给定集合中的最小值和最大值
     * @param data
     * @return [最小值, 最大值]
     */
    public static Double[] getMinimalAndMaximalValue(Collection<Double> data) {
        Double[] result = new Double[2];
        result[0] = result[1] = data.iterator().next();
        for (Double element : data) {
            if (element < result[0]) {
                result[0] = element;
            } else if (element > result[1]) { // 这里可以用 else if，因为 result[0] <= result[1]
                result[1] = element;
            }
        }
        return result;
    }



}
