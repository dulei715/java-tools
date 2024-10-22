package cn.edu.ecnu.struct;

import cn.edu.dll.constant_values.ConstantValues;
import cn.edu.dll.geometry.Line;
import cn.edu.dll.io.print.MyPrint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineTest {
    @Test
    public void fun1() {
        List<Line> lineList = new ArrayList<>();
        lineList.add(new Line(1, 1, 0));
        lineList.add(new Line(1, -1, 0));
        lineList.add(new Line(2, -1, 0));
        MyPrint.showList(lineList);
        Line[] lineArray = lineList.toArray(new Line[0]);
        MyPrint.showArray(lineArray, "; ");
        Arrays.sort(lineArray);
        MyPrint.showArray(lineArray, "; ");
    }
}
