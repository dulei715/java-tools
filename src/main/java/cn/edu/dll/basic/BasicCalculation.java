package cn.edu.dll.basic;


import cn.edu.dll.io.print.MyPrint;
import cn.edu.dll.struct.pair.BasicPair;
import cn.edu.dll.struct.point.DoublePoint;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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

    public static double get1Norm(DoublePoint pointA, DoublePoint pointB) {
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

    public static double get1Norm(DoublePoint pointA) {
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

    public static Double get2Norm(Double[] pointA, Double[] pointB) {
        if (pointA.length != pointB.length) {
            throw new RuntimeException("The dimensionality of two points are not equal!");
        }
        int len = pointA.length;
        Double result = 0D;
        for (int i = 0; i < len; i++) {
            result += Math.pow(pointA[i]-pointB[i], 2);
        }
        return Math.sqrt(result);
    }

    public static Double get2Norm(Double[] pointA) {
        int len = pointA.length;
        double result = 0;
        for (int i = 0; i < len; i++) {
            result += Math.pow(pointA[i], 2);
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

    public static Double get2Norm(BasicPair<Double, Double> pointA, BasicPair<Double, Double> pointB) {
        Double result = 0D;
        result += Math.pow(pointA.getKey() - pointB.getKey(), 2);
        result += Math.pow(pointA.getValue() - pointB.getValue(), 2);
        result = Math.sqrt(result);
        return result;
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

    public static double[] getNeighborDifference(final double[] data) {
        int size = data.length - 1;
        double[] result = new double[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = data[i+1] - data[i];
        }
        return result;
    }

    public static Double[] getNeighborDifference(final List<Double> data) {
        int size = data.size() - 1;
        Double[] result = new Double[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = data.get(i+1) - data.get(i);
        }
        return result;
    }

    public static Double[] getNeighborAbsDifference(final List<Double> data) {
        int size = data.size() - 1;
        Double[] result = new Double[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.abs(data.get(i+1) - data.get(i));
        }
        return result;
    }

    public static Double[] getEnhancedNeighborAbsDifference(final List<Double> data) {
        int size = data.size();
        Double[] result = new Double[size];
        result[0] = Math.abs(data.get(0));
        for (int i = 1; i < size; i++) {
            result[i] = Math.abs(data.get(i) - data.get(i-1));
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

    public static Integer getSquareValue(Integer[] point, Integer norm) {
        int len = point.length;
        Integer result = 0;
        for (int i = 0; i < len; i++) {
            result += (int)Math.pow(point[i], norm);
        }
        return result;
    }
    public static Integer getSquareValue(int[] point, Integer norm) {
        int len = point.length;
        Integer result = 0;
        for (int i = 0; i < len; i++) {
            result += (int)Math.pow(point[i], norm);
        }
        return result;
    }

    public static Double getSquareValue(Double[] point, Integer norm) {
        int len = point.length;
        Double result = 0D;
        for (int i = 0; i < len; i++) {
            result += Math.pow(point[i], norm);
        }
        return result;
    }
    public static Double getSquareValue(double[] point, Integer norm) {
        int len = point.length;
        Double result = 0D;
        for (int i = 0; i < len; i++) {
            result += Math.pow(point[i], norm);
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
    public static double get2NormSquare(BasicPair<Double, Double> pointA, BasicPair<Double, Double> pointB) {
        Double[] difference = new Double[]{pointA.getKey() - pointB.getKey(), pointA.getValue() - pointB.getValue()};
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

    public static Integer getNNormSquare(Integer[] pointA, Integer[] pointB, Integer squareNorm) {
        Integer[] difference = getDifference(pointA, pointB);
        return getSquareValue(difference, squareNorm);
    }

    public static Integer getNNormSquare(int[] pointA, int[] pointB, Integer squareNorm) {
        int[] difference = getDifference(pointA, pointB);
        return getSquareValue(difference, squareNorm);
    }

    public static Double getNNormSquare(Double[] pointA, Double[] pointB, Integer squareNorm) {
        Double[] difference = getDifference(pointA, pointB);
        return getSquareValue(difference, squareNorm);
    }




    public static double getSum(Double ... values) {
        double sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }
    public static double getSum(double ... values) {
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
     * 根据两点经纬度坐标计算直线距离
     * <p>
     * S = 2arcsin√sin²(a/2)+cos(lat1)*cos(lat2)*sin²(b/2)￣*6378.137
     * <p>
     * 1. lng1 lat1 表示A点经纬度，lng2 lat2 表示B点经纬度；<br>
     * 2. a=lat1 – lat2 为两点纬度之差  b=lng1 -lng2 为两点经度之差；<br>
     * 3. 6378.137为地球赤道半径，单位为千米；
     *
     * @param lng1 点1经度
     * @param lat1 点1纬度
     * @param lng2 点2经度
     * @param lat2 点2纬度
     * @return 距离，单位千米(KM)
     * @see <a href="https://zh.wikipedia.org/wiki/%E5%8D%8A%E6%AD%A3%E7%9F%A2%E5%85%AC%E5%BC%8F">半正矢(Haversine)公式</a>
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
     *  计算 sum(vectorA(i) * radix^vectorB(i))
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

    public static Double getInnerProduct(Double[] vectorA, Double[] vectorB) {
        int size = vectorA.length;
        Double result = 0.0;
        for (int i = 0; i < size; i++) {
            result += vectorA[i] * vectorB[i];
        }
        return result;
    }
    public static double getInnerProduct(double[] vectorA, double[] vectorB) {
        int size = vectorA.length;
        double result = 0.0;
        for (int i = 0; i < size; i++) {
            result += vectorA[i] * vectorB[i];
        }
        return result;
    }

    public static Double getPartInnerProduct(Double[] vectorA, Double[] vectorB, Collection<Integer> effectiveIndexCollection) {
        Double result = 0.0;
        for (Integer index : effectiveIndexCollection) {
            result += vectorA[index] * vectorB[index];
        }
        return result;
    }

    public static Double getPowerSum(double[] data, double indexValue) {
        Double result = 0D;
        for (double datum : data) {
            result += Math.pow(datum, indexValue);
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

    public static <T> Double getValueSum(Map<T, Double> map) {
        Double sum = 0.0;
        for (Map.Entry<T, Double> entry : map.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }

    public static Double[] getPairwiseMultiple(Double[] dataA, int indexValueA, Double[] dataB, int indexValueB) {
        int size = dataA.length;
        if (dataB.length != size) {
            throw new RuntimeException("The length is not equal!");
        }
        Double[] result = new Double[size];
        for (int i = 0; i < size; i++) {
            result[i] = Math.pow(dataA[i], indexValueA) * Math.pow(dataB[i],indexValueB);
        }
        return result;
    }
    public static double[] getPairwiseMultiple(double[] dataA, int indexValueA, double[] dataB, int indexValueB) {
        int size = dataA.length;
        if (dataB.length != size) {
            throw new RuntimeException("The length is not equal!");
        }
        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            result[i] = Math.pow(dataA[i], indexValueA) * Math.pow(dataB[i],indexValueB);
        }
        return result;
    }
    public static void setPairwiseMultiple(double[] result, double[] dataA, int indexValueA, double[] dataB, int indexValueB) {
        int size = dataA.length;
        if (dataB.length != size) {
            throw new RuntimeException("The length is not equal!");
        }
//        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            result[i] = Math.pow(dataA[i], indexValueA) * Math.pow(dataB[i],indexValueB);
        }
//        return result;
    }

    public static Double[] getMultiwiseMultiple(Double[]... data) {
        int size = data[0].length;
        for (int i = 0; i < data.length; i++) {
            if (data[i].length != size) {
                throw new RuntimeException("The length is not equal!");
            }
        }
        Double[] result = new Double[size];
        for (int j = 0; j < size; j++) {
            result[j] = 1D;
            for (int i = 0; i < data.length; i++) {
                result[j] *= data[i][j];
            }
        }
        return result;
    }
    public static double[] getMultiwiseMultiple(double[]... data) {
        int size = data[0].length;
        for (int i = 0; i < data.length; i++) {
            if (data[i].length != size) {
                throw new RuntimeException("The length is not equal!");
            }
        }
        double[] result = new double[size];
        for (int j = 0; j < size; j++) {
            result[j] = 1D;
            for (int i = 0; i < data.length; i++) {
                result[j] *= data[i][j];
            }
        }
        return result;
    }

    /**
     * 将给定的小数化成指定精度的小数
     * @param originalValue
     * @param precision
     * @return
     */
//    public static double getPrecisionValue(double originalValue, int precision) {
//        BigDecimal bigDecimal = new BigDecimal(originalValue);
//        return bigDecimal.setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue();
//    }
    public static double getPrecisionValue(double originalValue, int precision) {
        String formatStr = "%." + precision + "f";
        String doubleStr =  String.format(formatStr, originalValue);
        return Double.valueOf(doubleStr);
    }

    public static double[] getIntervalIntersection(double[] intervalA, double[] interValB) {
        if (intervalA[0] > intervalA[1] || interValB[0] > interValB[1]) {
            throw new RuntimeException("The intervals are not increasing!");
        }
        if (intervalA[0] > interValB[1] || intervalA[1] < interValB[0]) {
            return null;
        }
        return new double[]{Math.max(intervalA[0], interValB[0]), Math.min(intervalA[1], interValB[1])};
    }




    public static void main(String[] args) {
        String[] result2 = getRandomStringValueArrayInRange(10, 200, 2, 10);
        MyPrint.showStringArray(result2);
    }


}
