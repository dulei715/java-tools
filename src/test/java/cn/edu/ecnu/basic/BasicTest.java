package cn.edu.ecnu.basic;

import cn.edu.dll.basic.RandomUtil;
import cn.edu.dll.math.MathUtils;
import org.junit.Test;

public class BasicTest {
    @Test
    public void fun1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomUtil.getRandomInteger(0,1));
        }
    }
    @Test
    public void fun2() {
        int result = MathUtils.getBinomialResult(-1, 2);
        System.out.println(result);
    }
    @Test
    public void fun3() {
        Double a = 0.07;
        Double b = 0.01;
        System.out.println(a/b);
    }

    @Test
    public void fun4() {
//        double x = 12.345;
        double x = 12.545;
        long result = Math.round(x);
        System.out.println(result);
    }

    @Test
    public void fun5() {
        String valueStr = "Infinity";
        Double value = Double.valueOf(valueStr);
        System.out.println(value);
    }

    @Test
    public void fun6() {
        Double valueA = Double.POSITIVE_INFINITY;
        Double valueB = 2D;
        System.out.println(valueA + valueB);
        System.out.println(valueA - valueB);
        System.out.println(valueB - valueA);
        System.out.println(valueB / valueA);
    }

    @Test
    public void fun7() {
        System.out.println(Double.MAX_VALUE);
        System.out.println(-Double.MAX_VALUE);
    }

    @Test
    public void fun8() {
        Double value = 6.36E-05;
        System.out.println(value);
    }

    @Test
    public void fun9() {
        String valueStr = "6.36E-05";
        System.out.println(Double.valueOf(valueStr));
    }

}
