package cn.edu.ecnu;

import cn.edu.ecnu.basic.RandomUtil;
import cn.edu.ecnu.io.print.MyPrint;
import org.junit.Test;

import java.util.List;

public class RandomUtilTest {
    @Test
    public void fun1() {
        int lowerBound = 1;
        int upperBound = 100;
        int size = 20;
        List<Integer> result = RandomUtil.getRandomIntegerArrayWithoutRepeat(lowerBound, upperBound, size);
        MyPrint.showList(result);
    }
}
