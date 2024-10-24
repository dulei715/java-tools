package cn.edu.ecnu.basic;

import cn.edu.dll.collection.CollectionTools;
import cn.edu.dll.io.print.MyPrint;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CollectionUtilsTest {
    @Test
    public void fun1() {
        HashSet<Integer> setA = Sets.newHashSet(1, 2, 3, 4, 5);
        HashSet<Integer> setB = Sets.newHashSet(3, 4, 5, 6, 7, 9);
        Collection<Integer> setC = CollectionUtils.retainAll(setA, setB);
        MyPrint.showCollection(setC, ", ");

        Collection<Integer> setD = CollectionUtils.union(setA, setB);
        MyPrint.showCollection(setD, ", ");

        Collection<Integer> setE = CollectionUtils.subtract(setA, setB);
        MyPrint.showCollection(setE, ", ");
    }

    @Test
    public void fun2() {
        List<Double> list = new ArrayList<>();
        list.add(3.5);
        list.add(-4.2);
        list.add(7D);
        list.add(10.4);
        list.add(-2.1);
        Double[] result = CollectionTools.getMinimalAndMaximalValue(list);
        MyPrint.showArray(result);
    }
}
