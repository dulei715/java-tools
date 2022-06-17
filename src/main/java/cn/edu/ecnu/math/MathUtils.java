package cn.edu.ecnu.math;

import cn.edu.ecnu.basic.BasicArray;

public class MathUtils {
    /**
     *
     * @param n 正数
     * @param m 小于n的非负数
     * @return
     */
    public static int getBinaomialResult(int n, int m) {
        int [] tempArr;
        if (m == 0) {
            return 1;
        }
        int[] dataBefore = new int[m + 1];
        int[] dataNew = new int[m + 1];

        BasicArray.setIntArrayToZero(dataNew);
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
