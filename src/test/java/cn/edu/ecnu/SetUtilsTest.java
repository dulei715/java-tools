package cn.edu.ecnu;

import cn.edu.ecnu.collection.SetUtils;
import cn.edu.ecnu.io.print.MyPrint;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetUtilsTest {
    @Test
    public void fun1() {
        Set<Integer> data = new HashSet<>();
        data.add(3);
        data.add(5);
        data.add(2);
        data.add(9);
        MyPrint.showSet(data);
        MyPrint.showSplitLine("*", 150);
        Integer[] result = SetUtils.toArray(data, Integer.class);
        MyPrint.showArray(result);
    }

    @Test
    public void fun2() {
        TreeSet<Integer> data = new TreeSet<>();
        data.add(3);
        data.add(5);
        data.add(2);
        data.add(9);
        MyPrint.showSet(data);
        MyPrint.showSplitLine("*", 150);
        Integer[] result = SetUtils.toArray(data, Integer.class);
        MyPrint.showArray(result);
    }
    @Test
    public void fun3() {
        TreeSet<Integer> data = new TreeSet<>();
        data.add(3);
        data.add(4);
        data.add(6);
        Integer result = SetUtils.getElementByIndex(data, 1);
        System.out.println(result);
    }
}
