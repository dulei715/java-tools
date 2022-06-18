package cn.edu.ecnu.basic.cumulate;

public class CumulativeFunction {
    public static double getCumulativeFunctionValue(double[] distributionData, int num) {
        double result = 0;
        for (int i = 0; i < num; i++) {
            result += distributionData[i];
        }
        return result;
    }

    public static double getCumulativeFunctionValue(double[][] distributionData, int xNum, int yNum) {
        double result = 0;
        for (int i = 0; i < xNum; i++) {
            for (int j = 0; j < yNum; j++) {
                result += distributionData[i][j];
            }
        }
        return result;
    }

    public static Double[] getCumulativeDistribution(Double[] statisticDistribution) {
        int len = statisticDistribution.length;
        Double[] result = new Double[len];
        result[0] = statisticDistribution[0];
        for (int i = 1; i < len; i++) {
            result[i] = result[i-1] + statisticDistribution[i];
        }
        return result;
    }

    public static Integer[] getCumulativeDistribution(Integer[] statisticDistribution) {
        int len = statisticDistribution.length;
        Integer[] result = new Integer[len];
        result[0] = statisticDistribution[0];
        for (int i = 1; i < len; i++) {
            result[i] = result[i-1] + statisticDistribution[i];
        }
        return result;
    }

}
