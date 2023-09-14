package cn.edu.ecnu.experiment;

import cn.edu.ecnu.basic.BasicCalculation;
import cn.edu.ecnu.differential_privacy.ldp.consistent.Normalization;
import cn.edu.ecnu.io.print.MyPrint;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

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

    public static class TxtFileFilter implements FileFilter {
        @Override
        public boolean accept(File file) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileName.endsWith(".txt")) {
                    return true;
                }
            }
            return false;
        }
    }
}
