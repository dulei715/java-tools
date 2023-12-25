package cn.edu.dll.math;

import cn.edu.dll.basic.BasicArrayUtil;

public class MathUtils {
    /**
     *
     * @param n 非负正数
     * @param m 小于n的非负数
     * @return
     */
    public static int getBinomialResult(int n, int m) {
        if (n == 0) {
            if (m == 0) {
                return 1;
            }
            return 0;
        }
        int [] tempArr;
        if (m == 0) {
            return 1;
        }
        int[] dataBefore = new int[m + 1];
        int[] dataNew = new int[m + 1];

        BasicArrayUtil.setIntArrayToZero(dataNew);
        dataNew[0] = dataNew[1] = 1;

        for (int i = 1; i < n; i++) {
            tempArr = dataBefore;
            dataBefore = dataNew;
            dataNew = tempArr;

            dataNew[0] = 1;
            for (int j = m; j > 0; j--) {
                dataNew[j] = dataBefore[j] + dataBefore[j - 1];
            }
        }
        return dataNew[m];

    }
}
