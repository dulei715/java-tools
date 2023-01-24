package cn.edu.ecnu.collection;

import cn.edu.ecnu.differential_privacy.cdp.basic_struct.DistanceAble;

import java.util.Collection;

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




}
