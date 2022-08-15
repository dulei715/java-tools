package cn.edu.ecnu;

import cn.edu.ecnu.basic.RandomUtil;
import org.junit.Test;

public class BasicTest {
    @Test
    public void fun1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomUtil.getRandomInteger(0,1));
        }
    }
}
