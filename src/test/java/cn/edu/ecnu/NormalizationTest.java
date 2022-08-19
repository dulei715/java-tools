package cn.edu.ecnu;

import cn.edu.ecnu.basic.BasicCalculation;
import cn.edu.ecnu.differential_privacy.ldp.consistent.Normalization;
import cn.edu.ecnu.io.print.MyPrint;
import org.junit.Test;

public class NormalizationTest {
    @Test
    public void fun1() {
        double[] data = new double[]{
                1, 3.0, 5, 0.5, -2
        };
        double[] result = Normalization.normMul(data);
        MyPrint.showDoubleArray(result);
        double sum = BasicCalculation.getSum(result);
        System.out.println(sum);
    }
}
