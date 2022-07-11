package cn.edu.ecnu.math;


public class LambertW {
    public static final double INITIALIZED_VALUE = -2.0;
    public static final double DEFAULT_PRECISION = Math.pow(10,-6);
    public static double getMinusOneValue(double x, double precision) {
        double resultValueNew = LambertW.INITIALIZED_VALUE;
        double resultValueBefore;
        double tempA, tempB;
        do {
            resultValueBefore = resultValueNew;
            tempA = Math.exp(resultValueBefore);
            tempB = resultValueBefore * tempA;
            resultValueNew = (resultValueBefore * tempB + x) / (tempA + tempB);
        } while (Math.abs(resultValueNew - resultValueBefore) > precision);
        return resultValueNew;
    }

    public static double getMinusOneValue(double x) {
        return getMinusOneValue(x, DEFAULT_PRECISION);
    }

}
