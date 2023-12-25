package cn.edu.ecnu.struct;

import cn.edu.dll.constant_values.ConstantValues;
import cn.edu.dll.io.print.MyPrint;
import cn.edu.dll.struct.point.DoublePoint;
import cn.edu.dll.struct.point.TwoDimensionalDoublePoint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DoublePointTest {
    @Test
    public void fun1() {
        List<DoublePoint> pointAList = new ArrayList<>();
        List<DoublePoint> pointBList = new ArrayList<>();
        int len = 10;
        for (int i = 1; i <= len; i++) {
            pointAList.add(new TwoDimensionalDoublePoint(0.5 * i, 0.6 * i));
            pointBList.add(new TwoDimensionalDoublePoint(0.7 * i, 0.4 * i));
        }
        MyPrint.showList(pointAList, ConstantValues.LINE_SPLIT);
        MyPrint.showSplitLine("*", 150);
        MyPrint.showList(pointBList, ConstantValues.LINE_SPLIT);
        MyPrint.showSplitLine("*", 150);
        Double result = DoublePoint.getMSE(pointAList, pointBList);
        System.out.println(result);
    }
}
