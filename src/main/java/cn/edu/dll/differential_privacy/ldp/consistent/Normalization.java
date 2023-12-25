package cn.edu.dll.differential_privacy.ldp.consistent;

import java.util.ArrayList;
import java.util.List;

public class Normalization {
    public static double[] normMul(double[] originalDataArray) {
        int size = originalDataArray.length;
        double[] resultArray = new double[size];
        double sum = 0;
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (originalDataArray[i] < 0) {
                resultArray[i] = 0;
            } else {
                indexList.add(i);
                sum += originalDataArray[i];
            }
        }
        for (Integer j : indexList) {
            resultArray[j] = originalDataArray[j] / sum;
        }
        return resultArray;
    }
}
