package cn.edu.ecnu.basic;

import cn.edu.dll.basic.BasicCalculation;
import cn.edu.dll.io.print.MyPrint;
import org.junit.Test;

public class BasicCalculationTest {
    @Test
    public void fun1() {
        Double[] dataA = new Double[] {
                0.1, 0.2, 0.3, 0.4
        };
        Double[] dataB = new Double[] {
                0.5, 0.6, 0.7, 0.8
        };
        Double[] dataC = new Double[] {
                0.9, 1.0, 1.1, 1.2
        };
        Double[] result = BasicCalculation.getMultiwiseMultiple(dataA, dataB, dataC);
        MyPrint.showArray(result);
    }

    @Test
    public void fun2() {
        Double[] dataA = new Double[] {
                0.1, 0.2, 0.3, 0.4
        };
        Double[] dataB = new Double[] {
                0.5, 0.6, 0.7, 0.8
        };
        Double[] resultA = BasicCalculation.getPairwiseMultiple(dataA, 1, dataB, 1);
        MyPrint.showArray(resultA, ", ");
        Double[] resultB = BasicCalculation.getPairwiseMultiple(dataA, -1, dataB, 1);
        MyPrint.showArray(resultB, ", ");
        Double[] resultC = BasicCalculation.getPairwiseMultiple(dataA, 1, dataB, -1);
        MyPrint.showArray(resultC, ", ");
    }

    @Test
    public void fun3() {
        double result = BasicCalculation.getPrecisionValue(3.678, 2);
        System.out.println(result);
    }

}
