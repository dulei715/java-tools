package cn.edu.ecnu.struct;

import cn.edu.dll.io.print.MyPrint;
import cn.edu.dll.struct.grid.Grid;
import org.junit.Test;

public class GridTest {
    @Test
    public void fun1() {
        Double[] norm1DistanceArray = Grid.getDistinct1NormDistanceGivenIntegerSquareGridLength(4);
        MyPrint.showArray(norm1DistanceArray);
    }

    @Test
    public void fun2() {
        Double[] norm2DistanceArray = Grid.getDistinct2NormDistanceGivenIntegerSquareGridLength(4);
        MyPrint.showArray(norm2DistanceArray);
    }

    @Test
    public void fun3() {
        int gridLength = 3;
        int k = 1;
        double epsilon = 0.5;

    }
}
