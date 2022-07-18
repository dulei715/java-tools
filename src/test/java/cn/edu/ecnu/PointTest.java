package cn.edu.ecnu;

import cn.edu.ecnu.constant_values.ConstantValues;
import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.struct.point.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PointTest {
    @Test
    public void fun1() {
        List<Point> pointAList = new ArrayList<>();
        List<Point> pointBList = new ArrayList<>();
        int len = 10;
        for (int i = 1; i <= len; i++) {
            pointAList.add(new Point(0.5 * i, 0.6 * i));
            pointBList.add(new Point(0.7 * i, 0.4 * i));
        }
        MyPrint.showList(pointAList, ConstantValues.LINE_SPLIT);
        MyPrint.showSplitLine("*", 150);
        MyPrint.showList(pointBList, ConstantValues.LINE_SPLIT);
        MyPrint.showSplitLine("*", 150);
        Double result = Point.getMSE(pointAList, pointBList);
        System.out.println(result);
    }
}
