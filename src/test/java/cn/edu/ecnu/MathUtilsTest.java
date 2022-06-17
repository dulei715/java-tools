package cn.edu.ecnu;

import cn.edu.ecnu.math.MathUtils;
import org.junit.Test;

public class MathUtilsTest {
    @Test
    public void fun1() {
        int n = 5;
        int m = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m && j<= i; j++) {
                System.out.println(MathUtils.getBinaomialResult(i,j));
            }
        }
    }
}
