package cn.edu.ecnu.basic;

import cn.edu.ecnu.io.print.MyPrint;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

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
}
