package cn.edu.ecnu;

import cn.edu.ecnu.math.LambertW;
import org.junit.Test;

public class LambertWTest {
    @Test
    public void fun1() {
        double inputValue = -1.0 / Math.exp(1);
        System.out.println(LambertW.getMinusOneValue(inputValue));
    }

    @Test
    public void fun2() {
//        double inputValue = -0.001;
        double inputValue = -0.01;
//        double precision = Math.pow(10,-9);
//        System.out.println(LambertW.getMinusOneValue(inputValue, precision));
        System.out.println(LambertW.getMinusOneValue(inputValue));
    }

}
