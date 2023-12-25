package cn.edu.dll.struct.pair;

import java.util.*;

@SuppressWarnings("Duplicates")
public class PairListUtils {
    public static <T extends Comparable<T>> IdentityPair<T> getExchangeKeyValuePair(IdentityPair<T> originalPair) {
        T key = originalPair.getKey();
        T value = originalPair.getValue();
        return new IdentityPair<>(value, key);
    }

    /**
     * 返回原始列表中交换了key和value的新的pair（不改变原始值）
     * @param originalCollection
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> Collection<IdentityPair<T>> getExchangeKeyValuePairList(Collection<? extends IdentityPair<T>> originalCollection) {
        int size = originalCollection.size();
        List<IdentityPair<T>> resultList = new ArrayList<>(size);
        for (IdentityPair<T> identityPair : originalCollection) {
            resultList.add(getExchangeKeyValuePair(identityPair));
        }
        return resultList;
    }

    public static <K extends Comparable<K>, V extends Comparable<V>> TreeMap<K, TreeSet<BasicPair<K, V>>> groupByKey(Collection<? extends BasicPair<K, V>> originalCollection) {
        TreeMap<K, TreeSet<BasicPair<K, V>>> resultMap = new TreeMap<>();
        K tempK;
        TreeSet<BasicPair<K, V>> tempTreeSet;
        for (BasicPair<K, V> basicPair : originalCollection) {
            tempK = basicPair.getKey();
            tempTreeSet = resultMap.get(tempK);
            if (tempTreeSet == null) {
                tempTreeSet = new TreeSet<>();
                tempTreeSet.add(basicPair);
                resultMap.put(tempK, tempTreeSet);
            } else {
                tempTreeSet.add(basicPair);
            }
        }
        return resultMap;
    }

    public static <K extends Comparable<K>, V extends Comparable<V>> TreeMap<V, TreeSet<BasicPair<K, V>>> groupByValue(Collection<? extends BasicPair<K, V>> originalCollection) {
        TreeMap<V, TreeSet<BasicPair<K, V>>> resultMap = new TreeMap<>();
        V tempV;
        TreeSet<BasicPair<K, V>> tempTreeSet;
        for (BasicPair<K, V> basicPair : originalCollection) {
            tempV = basicPair.getValue();
            tempTreeSet = resultMap.get(tempV);
            if (tempTreeSet == null) {
                tempTreeSet = new TreeSet<>();
                tempTreeSet.add(basicPair);
                resultMap.put(tempV, tempTreeSet);
            } else {
                tempTreeSet.add(basicPair);
            }
        }
        return resultMap;
    }

}
