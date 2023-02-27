package cn.edu.ecnu;

import cn.edu.ecnu.basic.RandomUtil;
import cn.edu.ecnu.math.MathUtils;
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
}
