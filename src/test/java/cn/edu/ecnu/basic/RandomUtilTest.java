package cn.edu.ecnu.basic;

import cn.edu.dll.basic.RandomUtil;
import cn.edu.dll.io.print.MyPrint;
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
    
    @Test
    public void fun4() {
        double probability = 0.6;
//        double probability = 0;
        boolean[] result = new boolean[100000];
        for (int i = 0; i < result.length; i++) {
            result[i] = RandomUtil.isChosen(probability);
        }
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i]) {
                ++count;
            }
        }
        System.out.println(count*1.0/ result.length);
    }

}
