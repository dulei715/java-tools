package cn.edu.ecnu.basic;


import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.struct.point.Point;

import java.text.DecimalFormat;
import java.util.Arrays;

@SuppressWarnings("ALL")
public class BasicCalculation {
    public static final int ESTIMATION_VALUE_INDEX = 0;
    public static final int WEIGHTED_INDEX = 1;

    public static double get1Norm(double[] pointA, double[] pointB) {
        if (pointA.length != pointB.length) {
            throw new RuntimeException("The dimensionality of two points are not equal!");
        }
        int len = pointA.length;
        double result = 0;
        for (int i = 0; i < len; i++) {
            result += Math.abs(pointA[i]-pointB[i]);
        }
        return result;
    }

    public static Double get1Norm(Double[] pointA, Double[] pointB) {
        if (pointA.length != pointB.length) {
            throw new RuntimeException("The dimensionality of two points are not equal!");
        }
        int len = pointA.length;
        Double result = 0.0;
        for (int i = 0; i < len; i++) {
            result += Math.abs(pointA[i]-pointB[i]);
        }
        return result;
    }

    public static int get1Norm(int[] pointA, int[] pointB) {
        if (pointA.length != pointB.length) {
            throw new RuntimeException("The dimensionality of two points are not equal!");
        }
        int len = pointA.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            result += Math.abs(pointA[i]-pointB[i]);
        }
        return result;
    }

    public static Integer get1Norm(Integer[] pointA, Integer[] pointB) {
        if (pointA.length != pointB.length) {
            throw new RuntimeException("The dimensionality of two points are not equal!");
        }
        int len = pointA.length;
        Integer result = 0;
        for (int i = 0; i < len; i++) {
            result += Math.abs(pointA[i]-pointB[i]);
        }
        return result;
    }

    public static double get1Norm(double[] pointA) {
        int len = pointA.length;
        double result = 0;
        for (int i = 0; i < len; i++) {
            result += Math.abs(pointA[i]);
        }
        return result;
    }

    public static double get1Norm(Point pointA, Point pointB) {
        if (pointA.getDimensionalSize() != pointB.getDimensionalSize()) {
            throw new RuntimeException("The dimensionality of two points are not equal!");
        }
        int len = pointA.getDimensionalSize();
        double result = 0;
        Double[] pointAArray = pointA.getValueArray();
        Double[] pointBArray = pointB.getValueArray();
        for (int i = 0; i < len; i++) {
            result += Math.abs(pointAArray[i] - pointBArray[i]);
        }
        return result;
    }

    public static double get1Norm(Point pointA) {
        int len = pointA.getDimensionalSize();
        double result = 0;
        Double[] pointAArray = pointA.getValueArray();
        for (int i = 0; i < len; i++) {
            result += Math.abs(pointAArray[i]);
        }
        return result;
    }


    public static double get2Norm(double[] pointA, double[] pointB) {
        if (pointA.length != pointB.length) {
            throw new RuntimeException("The dimensionality of two points are not equal!");
        }
        int len = pointA.length;
        double result = 0;
        for (int i = 0; i < len; i++) {
            result += Math.pow(pointA[i]-pointB[i], 2);
        }
        return Math.sqrt(result);
    }

    public static double get2Norm(double[] pointA) {
        int len = pointA.length;
        double result = 0;
        for (int i = 0; i < len; i++) {
            result += Math.pow(pointA[i], 2);
        }
        return Math.sqrt(result);
    }

    public static double[] getDifference(double[] pointA, double[] pointB) {
        if (pointA.length != pointB.length) {
            throw new RuntimeException("The dimensionality of two points are not equal!");
        }
        int len = pointA.length;
        double[] result = new double[len];
        for (int i = 0; i < len; i++) {
            result[i] = pointA[i] - pointB[i];
        }
        return result;
    }

    public static Double[] getDifference(Double[] pointA, Double[] pointB) {
        if (pointA.length != pointB.length) {
            throw new RuntimeException("The dimensionality of two points are not equal!");
        }
        int len = pointA.length;
        Double[] result = new Double[len];
        for (int i = 0; i < len; i++) {
            result[i] = pointA[i] - pointB[i];
        }
        return result;
    }

    public static Integer[] getDifference(Integer[] pointA, Integer[] pointB) {
        if (pointA.length != pointB.length) {
            throw new RuntimeException("The dimensionality of two points are not equal!");
        }
        int len = pointA.length;
        Integer[] result = new Integer[len];
        for (int i = 0; i < len; i++) {
            result[i] = pointA[i] - pointB[i];
        }
        return result;
    }

    public static int[] getDifference(int[] pointA, int[] pointB) {
        if (pointA.length != pointB.length) {
            throw new RuntimeException("The dimensionality of two points are not equal!");
        }
        int len = pointA.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = pointA[i] - pointB[i];
        }
        return result;
    }

    public static double getSquareValue(double[] point) {
        int len = point.length;
        double result = 0;
        for (int i = 0; i < len; i++) {
            result += Math.pow(point[i], 2);
        }
        return result;
    }

    public static Double getSquareValue(Double[] point) {
        int len = point.length;
        Double result = 0.0;
        for (int i = 0; i < len; i++) {
            result += Math.pow(point[i], 2);
        }
        return result;
    }

    public static Integer getSquareValue(Integer[] point) {
        int len = point.length;
        Integer result = 0;
        for (int i = 0; i < len; i++) {
            result += (int)Math.pow(point[i], 2);
        }
        return result;
    }

    public static int getSquareValue(int[] point) {
        int len = point.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            result += (int)Math.pow(point[i], 2);
        }
        return result;
    }

    public static double get2NormSquare(double[] pointA, double[] pointB) {
        double[] difference = getDifference(pointA, pointB);
        return getSquareValue(difference);
    }
    public static double get2NormSquare(Double[] pointA, Double[] pointB) {
        Double[] difference = getDifference(pointA, pointB);
        return getSquareValue(difference);
    }
    public static int get2NormSquare(int[] pointA, int[] pointB) {
        int[] difference = getDifference(pointA, pointB);
        return getSquareValue(difference);
    }

    public static Integer get2NormSquare(Integer[] pointA, Integer[] pointB) {
        Integer[] difference = getDifference(pointA, pointB);
        return getSquareValue(difference);
    }


    public static double getSum(double ... values) {
        double sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    public static double getSum(Double ... values) {
        double sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }


    public static double radians(double d) {
        return d * Math.PI / 180.0;
    }
    /**
     * ?????????????????????????????????????????????
     * <p>
     * S = 2arcsin???sin??(a/2)+cos(lat1)*cos(lat2)*sin??(b/2)???*6378.137
     * <p>
     * 1. lng1 lat1 ??????A???????????????lng2 lat2 ??????B???????????????<br>
     * 2. a=lat1 ??? lat2 ?????????????????????  b=lng1 -lng2 ????????????????????????<br>
     * 3. 6378.137??????????????????????????????????????????
     *
     * @param lng1 ???1??????
     * @param lat1 ???1??????
     * @param lng2 ???2??????
     * @param lat2 ???2??????
     * @return ?????????????????????(KM)
     * @see <a href="https://zh.wikipedia.org/wiki/%E5%8D%8A%E6%AD%A3%E7%9F%A2%E5%85%AC%E5%BC%8F">?????????(Haversine)??????</a>
     */
    public static double getDistanceFrom2LngLat(double lng1, double lat1, double lng2, double lat2) {
        double radLng1 = radians(lng1);
        double radLat1 = radians(lat1);
        double radLng2 = radians(lng2);
        double radLat2 = radians(lat2);

        double a = radLat1 - radLat2;
        double b = radLng1 - radLng2;

        return 2 * Math.asin(Math.sqrt(Math.sin(a / 2) * Math.sin(a / 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.sin(b / 2) * Math.sin(b / 2))) * 6378.137;
    }

    public static double getAverage(double averageBefore, double newValue, int count) {
        return (averageBefore*(count-1)+newValue)/count;
    }

    public static double getAverage(double ... values) {
        return getSum(values)/ values.length;
    }

    public static double getWeightedFirstVectorNormOfDifference(double[][] estimationAndWeighted, double realValue) {
        double result = 0;
        for (int i = 0; i < estimationAndWeighted.length; i++) {
            result += estimationAndWeighted[i][ESTIMATION_VALUE_INDEX] * Math.abs(realValue - estimationAndWeighted[i][WEIGHTED_INDEX]);
        }
        return result;
    }


    public static Double getRandomDoubleValueInRange(double lowerBound, double upperBound, int precision) {
        if (precision < 0) {
            throw new RuntimeException("The precision should not be negative!");
        }
        double randomValue = Math.random();
        Double result;
        String tag = "0";
        if (precision > 0) {
            tag += ".";
        }
        for (int i = 0; i < precision; i++) {
            tag += "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(tag);
        double candidateValue = lowerBound + randomValue * (upperBound - lowerBound);
        result = Double.valueOf(decimalFormat.format(candidateValue));
        return result;
    }

    public static Double[] getRandomDoubleValueArrayInRange(double lowerBound, double upperBound, int precision, int arraySize) {
        if (precision < 0) {
            throw new RuntimeException("The precision should not be negative!");
        }
        double randomValue, candidateValue;
        String tag = "0";
        Double[] result = new Double[arraySize];
        if (precision > 0) {
            tag += ".";
        }
        for (int i = 0; i < precision; i++) {
            tag += "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(tag);
        for (int i = 0; i < arraySize; i++) {
            randomValue = Math.random();
            candidateValue = lowerBound + randomValue * (upperBound - lowerBound);
            result[i] = Double.valueOf(decimalFormat.format(candidateValue));
        }
        return result;
    }

    public static String getRandomStringValueInRange(double lowerBound, double upperBound, int precision) {
        if (precision < 0) {
            throw new RuntimeException("The precision should not be negative!");
        }
        double randomValue = Math.random();
        String result;
        String tag = "0";
        if (precision > 0) {
            tag += ".";
        }
        for (int i = 0; i < precision; i++) {
            tag += "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(tag);
        double candidateValue = lowerBound + randomValue * (upperBound - lowerBound);
        result = decimalFormat.format(candidateValue);
        return result;
    }

    public static String[] getRandomStringValueArrayInRange(double lowerBound, double upperBound, int precision, int arraySize) {
        if (precision < 0) {
            throw new RuntimeException("The precision should not be negative!");
        }
        double randomValue, candidateValue;
        String tag = "0";
        String[] result = new String[arraySize];
        if (precision > 0) {
            tag += ".";
        }
        for (int i = 0; i < precision; i++) {
            tag += "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(tag);
        for (int i = 0; i < arraySize; i++) {
            randomValue = Math.random();
            candidateValue = lowerBound + randomValue * (upperBound - lowerBound);
            result[i] = decimalFormat.format(candidateValue);
        }
        return result;
    }

    /**
     *  ?????? sum(vectorA(i) * radix^vectorB(i))
     * @param vectorA
     * @param exponentVectorB
     * @param radix
     * @return
     */
    public static Double getInnerProduct(Integer[] vectorA, Double[] exponentVectorB, double radix) {
        int size = vectorA.length;
        Double result = 0.0;
        for (int i = 0; i < size; i++) {
            result += vectorA[i] * Math.pow(radix, exponentVectorB[i]);
        }
        return result;
    }




    public static String[][] getRandomStringValueTwoDimensionArrayInRange(double lowerBound, double upperBound, int precision, int arraySize, int innerArraySize) {
        if (precision < 0) {
            throw new RuntimeException("The precision should not be negative!");
        }
        double randomValue, candidateValue;
        String tag = "0";
        String[][] result = new String[arraySize][innerArraySize];
        if (precision > 0) {
            tag += ".";
        }
        for (int i = 0; i < precision; i++) {
            tag += "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(tag);
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < innerArraySize; j++) {
                randomValue = Math.random();
                candidateValue = lowerBound + randomValue * (upperBound - lowerBound);
                result[i][j] = decimalFormat.format(candidateValue);
            }
        }
        return result;
    }

    public static String[][] getSortedRandomStringValueTwoDimensionArrayInRange(double lowerBound, double upperBound, int precision, int arraySize, int innerArraySize) {
        if (precision < 0) {
            throw new RuntimeException("The precision should not be negative!");
        }
        double randomValue, candidateValue;
        String tag = "0";
        String[][] result = new String[arraySize][innerArraySize];
        double[] tempArray = new double[innerArraySize];
        if (precision > 0) {
            tag += ".";
        }
        for (int i = 0; i < precision; i++) {
            tag += "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(tag);
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < innerArraySize; j++) {
                randomValue = Math.random();
                candidateValue = lowerBound + randomValue * (upperBound - lowerBound);
                tempArray[j] = candidateValue;
            }

            Arrays.sort(tempArray);

            for (int j = 0; j < innerArraySize; j++) {
                result[i][j] = decimalFormat.format(tempArray[j]);
            }

        }
        return result;
    }


    public static void main(String[] args) {
        String[] result2 = getRandomStringValueArrayInRange(10, 200, 2, 10);
        MyPrint.showStringArray(result2);
    }


}
