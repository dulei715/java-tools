package cn.edu.ecnu;

import cn.edu.ecnu.struct.pair.IdentityPair;
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

    @Test
    public void fun2() {
        IdentityPair<Integer> elementA = new IdentityPair<>(2, 3);
        IdentityPair<Double> elementB = new IdentityPair<>(2.0, 3.0);
        System.out.println(elementA.equals(elementB));

        Integer elementC = new Integer(3);
        Double elementD = new Double(3.0);
        System.out.println(elementC.equals(elementD));

    }

}
