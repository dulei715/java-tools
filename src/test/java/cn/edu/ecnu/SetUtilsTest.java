package cn.edu.ecnu;

import cn.edu.ecnu.collection.SetUtils;
import cn.edu.ecnu.constant_values.ConstantValues;
import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.*;

public class SetUtilsTest {
    @Test
    public void fun1() {
        Set<Integer> data = new HashSet<>();
        data.add(3);
        data.add(5);
        data.add(2);
        data.add(9);
        MyPrint.showCollection(data);
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
        MyPrint.showCollection(data);
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

    @Test
    public void fun4() {
        int n = 5;
        int k = 2;
        List<List<Integer>> resultList = SetUtils.getSubsetList(n, k, 2);
        MyPrint.showList(resultList, ConstantValues.LINE_SPLIT);
    }


    @Test
    public void fun5() {
        List<TwoDimensionalIntegerPoint> originalList = new ArrayList<>();
        originalList.add(new TwoDimensionalIntegerPoint(1, 2));
        originalList.add(new TwoDimensionalIntegerPoint(3, 4));
        originalList.add(new TwoDimensionalIntegerPoint(4, 2));
        originalList.add(new TwoDimensionalIntegerPoint(5, 6));
        originalList.add(new TwoDimensionalIntegerPoint(7, 8));

        MyPrint.showList(originalList, ConstantValues.LINE_SPLIT);
        MyPrint.showSplitLine("*", 150);
        List<List<TwoDimensionalIntegerPoint>> sublistList = SetUtils.getSublistList(originalList, 2);
        MyPrint.showList(sublistList, ConstantValues.LINE_SPLIT);

    }

    @Test
    public void fun6() {
        int n = 36;
        int k = 6;
        List<List<Integer>> subsetList = SetUtils.getSubsetList(n, k, 0);
        MyPrint.showList(subsetList, ConstantValues.LINE_SPLIT);
    }


}
