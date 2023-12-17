package cn.edu.ecnu.basic;

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
    @Test
    public void fun3() {
        int lowerBound = 1;
        int upperBound = 100;
        int size = 20;
        int[] result = RandomUtil.getRandomIntArrayWithoutRepeat(lowerBound, upperBound, size);
        MyPrint.showIntegerArray(result);
    }

    @Test
    public void fun2() {
        Integer[] partCounts = new Integer[]{
                495, 0, 0, 0, 0
        };
//        while (true) {
//            Integer index = RandomUtil.getRandomIndexGivenStatisticPoint(partCounts);
//            if (index > 0) {
//                System.out.println(index);
//                break;
//            }
//        }
    }

}
