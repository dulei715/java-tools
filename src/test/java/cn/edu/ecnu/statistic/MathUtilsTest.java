package cn.edu.ecnu.statistic;

import cn.edu.ecnu.math.MathUtils;
import org.junit.Test;

public class MathUtilsTest {
    @Test
    public void fun1() {
        int n = 5;
        int m = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m && j<= i; j++) {
                System.out.println(MathUtils.getBinomialResult(i,j));
            }
        }
    }

    @Test
    public void fun2() {
        int n = 5;
        int m = 6;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.println(MathUtils.getBinomialResult(i,j));
            }
        }
    }

    @Test
    public void fun3 () {
        int k = 3;
        int n = 20;
        int a = 12;

        int resultA = 0;
        for (int i = 1; i <= k; i++) {
            resultA += MathUtils.getBinomialResult(a, i) * MathUtils.getBinomialResult(n-a, k-i);
        }

        int resultB = MathUtils.getBinomialResult(n, k) - MathUtils.getBinomialResult(n-a, k);

        System.out.println(resultA);
        System.out.println(resultB);

    }

    @Test
    public void fun4() {
        int result = MathUtils.getBinomialResult(0, 1);
        System.out.println(result);
    }

}
