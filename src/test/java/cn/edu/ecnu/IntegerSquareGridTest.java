package cn.edu.ecnu;

import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.struct.grid.IntegerSquareGrid;
import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.Collection;
import java.util.Set;

public class IntegerSquareGridTest {
    @Test
    public void fun1() {
        Set<TwoDimensionalIntegerPoint> result = IntegerSquareGrid.generateSet(4);
        MyPrint.showCollection(result);
    }

    @Test
    public void fun2() {
        Set<TwoDimensionalIntegerPoint> setA = IntegerSquareGrid.generateSet(5);
        Set<TwoDimensionalIntegerPoint> setB = IntegerSquareGrid.generateSet(4);
        Collection setC = CollectionUtils.subtract(setA, setB);
        MyPrint.showCollection(setC);
    }
}
