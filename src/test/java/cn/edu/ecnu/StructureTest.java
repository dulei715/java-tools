package cn.edu.ecnu;

import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;
import org.junit.Test;

public class StructureTest {
    @Test
    public void fun1() {
        TwoDimensionalIntegerPoint elemA = new TwoDimensionalIntegerPoint(3, 4);
        int paramA = 1;
        TwoDimensionalIntegerPoint elemB = new TwoDimensionalIntegerPoint(5, 7);
        int paramB = 1;
        TwoDimensionalIntegerPoint resultPoint = TwoDimensionalIntegerPoint.integerLinearCompose(elemA, paramA, elemB, paramB);
        System.out.println(resultPoint);
    }
}
