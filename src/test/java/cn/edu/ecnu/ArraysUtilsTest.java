package cn.edu.ecnu;

import cn.edu.ecnu.collection.ArraysUtils;
import cn.edu.ecnu.collection.ListUtils;
import cn.edu.ecnu.constant_values.ConstantValues;
import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ArraysUtilsTest {
    @Test
    public void fun1() {
        TwoDimensionalIntegerPoint point = new TwoDimensionalIntegerPoint(3, 4);
        TwoDimensionalIntegerPoint[] resultArray = ArraysUtils.copyToArrayGivenElement(point, 10);
        MyPrint.showArray(resultArray);
        MyPrint.showSplitLine("*", 150);
        point.setXIndex(6);
        MyPrint.showArray(resultArray);
    }

    @Test
    public void fun2() {
        TwoDimensionalIntegerPoint point = new TwoDimensionalIntegerPoint(3, 4);
        List<TwoDimensionalIntegerPoint> List = ListUtils.copyToListGivenElement(point, 10);
        MyPrint.showList(List, ConstantValues.LINE_SPLIT);
        MyPrint.showSplitLine("*", 150);
        point.setXIndex(6);
        MyPrint.showList(List, ConstantValues.LINE_SPLIT);
    }

    @Test
    public void fun3_1() {
        double[] arr = new double[] {
                13.2, 16.5, 18.4, 22.2, 23.1
        };
        int len = arr.length;
        double key = 23.0;
        int index = Arrays.binarySearch(arr, key);
        System.out.println(index);
    }

    @Test
    public void fun3() {
        double[] arr = new double[] {
                23.1, 22.2, 18.4, 16.5, 13.2
        };
        double key = 12.4;
        int index = ArraysUtils.binaryDescendSearch(arr, key);
        System.out.println(index);
    }

}
