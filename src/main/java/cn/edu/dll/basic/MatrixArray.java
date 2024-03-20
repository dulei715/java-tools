package cn.edu.dll.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class MatrixArray {

    public static Double[][] toMatrixArray(List<List<Double>> data) {
        int size = data.size();
        int sizeCol = data.get(0).size();
        Double[][] result = new Double[size][sizeCol];
        List<Double> tempList;
        for (int i = 0; i < size; i++) {
            tempList = data.get(i);
            for (int j = 0; j < sizeCol; j++) {
                result[i][j] = tempList.get(j);
            }
        }
        return result;
    }

    /**
     * 获取matrix中元素的最大值
     * @param matrix
     * @return
     */
    public static double getMaxValue(double[][] matrix) {
        double result = Double.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > result) {
                    result = matrix[i][j];
                }
            }
        }
        return result;
    }

    /**
     * 获取matrix的行数和列数
     * @param matrix
     * @return
     */
    public static int[] getMatrixSize(double[][] matrix) {
        int lineNumber = matrix.length;
        int colNumber = matrix[0].length;
        return new int[]{lineNumber, colNumber};
    }

    public static <T> int[] getMatrixSize(List<List<T>> data) {
        int[] size = new int[2];
        size[0] = data.size();
        size[1] = data.get(0).size();
        return size;
    }

    /**
     * 生成给定值行数和列数，且给定值的矩阵
     * @param size
     * @param defaultValue
     * @return
     */
    public static int[][] getIntegerMatrixWithDeclaredSize(int[] size, int defaultValue) {
        int[][] result = new int[size[0]][size[1]];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = defaultValue;
            }
        }
        return result;
    }

    /**
     * 返回matrix状态矩阵，等于给定的value，值为1，否则为0
     * @param matrix
     * @param value
     * @return
     */
    public static int[][] getResultStateWhetherEqualsToDeclaredValue(double[][] matrix, double value) {
        // 相等置为1， 不等置为0
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (matrix[i][j] == value) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }

    /**
     * 返回matrix状态矩阵，等于给定的value，值为1，否则为0
     * @param matrix
     * @param value
     * @return
     */
    public static int[][] getResultStateWhetherEqualsToDeclaredValue(int[][] matrix, int value) {
        // 相等置为1， 不等置为0
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (matrix[i][j] == value) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }

    /**
     * 逐行统计每行等于给定value的个数
     * @param matrix
     * @param value
     * @return
     */
    public static int[] getRowCountEqualDeclaredValue(int[][] matrix, int value) {
        int size = matrix.length;
        int[] result = new int[size];
//        BasicArray.setIntArrayToZero(result);
        for (int i = 0; i < size; i++) {
            result[i] = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == value) {
                    result[i] ++;
                }
            }
        }
        return result;
    }

    /**
     * 逐列统计每列等于给定value值的个数
     * @param matrix
     * @param value
     * @return
     */
    public static int[] getColCountEqualDeclaredValue(int[][] matrix, int value) {
        int size = matrix[0].length;
        int[] result = new int[size];
//        BasicArray.setIntArrayToZero(result);
        for (int j = 0; j < size; j++) {
            result[j] = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == value) {
                    result[j] ++;
                }
            }
        }
        return result;
    }

    /**
     * 返回给定行中等于给定value的列的集合
     * @param matrix
     * @param rowIndex
     * @param value
     * @return
     */
    public static List<Integer> getColIndexListWithDeclareRowIndexAndValue(int[][] matrix, int rowIndex, int value) {
        List<Integer> colIndexList = new ArrayList<>();
        for (int j = 0; j < matrix[rowIndex].length; j++) {
            if (matrix[rowIndex][j] == value) {
                colIndexList.add(j);
            }
        }
        return colIndexList;
    }

    /**
     * 返回给定多个行中值等于给定value的列的集合
     * @param matrix
     * @param rowIndexList
     * @param value
     * @return
     */
    public static List<Integer> getColIndexListWithDeclareRowIndexAndValue(int[][] matrix, List<Integer> rowIndexList, int value) {
        TreeSet<Integer> colIndexTreeSet = new TreeSet<>();
        List<Integer> result = new ArrayList<>();
        List<Integer> tempList;
        for (int i = 0; i < rowIndexList.size(); i++) {
            tempList = getColIndexListWithDeclareRowIndexAndValue(matrix, rowIndexList.get(i), value);
            colIndexTreeSet.addAll(tempList);
        }
        result.addAll(colIndexTreeSet);
        return result;
    }

    /**
     * 返回给定列中值等于value的行的集合
     * @param matrix
     * @param colIndex
     * @param value
     * @return
     */
    public static List<Integer> getRowIndexListWithDeclareColIndexAndValue(int[][] matrix, int colIndex, int value) {
        List<Integer> rowIndexList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][colIndex] == value) {
                rowIndexList.add(i);
            }
        }
        return rowIndexList;
    }


    /**
     * 返回给定多个列中值等于value的行的集合
     * @param matrix
     * @param colIndexList
     * @param value
     * @return
     */
    public static List<Integer> getRowIndexListWithDeclareColIndexAndValue(int[][] matrix, List<Integer> colIndexList, int value) {
        TreeSet<Integer> rowIndexTreeSet = new TreeSet<>();
        List<Integer> result = new ArrayList<>();
        List<Integer> tempList;
        for (int i = 0; i < colIndexList.size(); i++) {
            tempList = getRowIndexListWithDeclareColIndexAndValue(matrix, colIndexList.get(i), value);
            rowIndexTreeSet.addAll(tempList);
        }
        result.addAll(rowIndexTreeSet);
        return result;
    }

    /**
     * 讲给定的行和列的笛卡尔积坐标对应的值设置为给定的value
     * @param matrix
     * @param rowIndexList
     * @param colIndexList
     * @param value
     */
    public static void setValue(int[][] matrix, List<Integer> rowIndexList, List<Integer> colIndexList, int value) {
        for (Integer rowIndex : rowIndexList) {
            for (Integer colIndex : colIndexList) {
                matrix[rowIndex][colIndex] = value;
            }
        }
    }

    /**
     * 将矩阵的每个元素修改成原本值的线性变换
     * @param matrix
     * @param paramMulti
     * @param paramAdd
     */
    public static void linearHandleEachElement(double[][] matrix, double paramMulti, double paramAdd) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = paramMulti * matrix[i][j] + paramAdd;
            }
        }
    }

    /**
     * 将fromMatrix复制到toMatrix，空余部分用给定的defaultValue填充
     * @param fromMatrix
     * @param toMatrix
     * @param defaultValue
     * @param paramMulti
     * @param paramAdd
     */
    public static void linearHandleMatrix(double[][] fromMatrix, double[][] toMatrix, double defaultValue, double paramMulti, double paramAdd) {
        int[] fromMatrixSize = getMatrixSize(fromMatrix);
        for (int i = 0; i < toMatrix.length; i++) {
            for (int j = 0; j < toMatrix[0].length; j++) {
                if (i < fromMatrixSize[0] && j < fromMatrixSize[1]) {
                    toMatrix[i][j] = fromMatrix[i][j] * paramMulti + paramAdd;
                } else {
                    toMatrix[i][j] = defaultValue;
                }
            }
        }
    }

    /**
     * 将给定rowIndex中给定的colIndexList对应的值设置为value
     * 如果rowIndex<0，则将所有行对应的colIndexList中的值设置为value
     * @param matrix
     * @param rowIndex
     * @param colIndexList
     * @param value
     */
    public static void setValue(int[][] matrix, int rowIndex, List<Integer> colIndexList, int value) {
        if (rowIndex <= -1) {
            for (int i = 0; i < matrix.length; i++) {
                for (Integer colIndex : colIndexList) {
                    matrix[i][colIndex] = value;
                }
            }
        } else {
            for (Integer colIndex : colIndexList) {
                matrix[rowIndex][colIndex] = value;
            }
        }
    }

    /**
     * 将给定列的给定行的集合对应的值设置为给定的value
     * 如果列<0，则将所有的列中给定的行的集合对应的值都设置为value
     * @param matrix
     * @param rowIndexList
     * @param colIndex
     * @param value
     */
    public static void setValue(int[][] matrix, List<Integer> rowIndexList, int colIndex, int value) {
        if (colIndex <= -1) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (Integer rowIndex : rowIndexList) {
                    matrix[rowIndex][j] = value;
                }
            }
        } else {
            for (Integer rowIndex : rowIndexList) {
                matrix[rowIndex][colIndex] = value;
            }
        }
    }

    /**
     * 将给定行和列的值设置为value值
     * @param matrix
     * @param rowIndex
     * @param colIndex
     * @param value
     */
    public static void setValue(int[][] matrix, int rowIndex, int colIndex, int value) {
        if (rowIndex <= -1 && colIndex <= -1) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = value;
                }
            }
        } else {
            if (colIndex <= -1) {
                for (int j = 0; j < matrix[rowIndex].length; j++) {
                    matrix[rowIndex][j] = value;
                }
            } else if (rowIndex <= -1) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][colIndex] = value;
                }
            } else {
                matrix[rowIndex][colIndex] = value;
            }
        }
    }

    /**
     * 获取由state指定的matrix中元素的线性变换的和
     * @param matrix
     * @param state
     * @param paramMulti
     * @param paramAdd
     * @return
     */
    public static double getMatrixLinearChangeElementMultipleResult(double[][] matrix, int[][] state, double paramMulti, double paramAdd) {
        double result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result += (matrix[i][j] * paramMulti + paramAdd) * state[i][j];
            }
        }
        return result;
    }

    /**
     * 获取由state指定的matrix中元素的和
     * @param matrix
     * @param state
     * @return
     */
    public static double getMatrixElementMultipleResult(double[][] matrix, int[][] state) {
        return getMatrixLinearChangeElementMultipleResult(matrix, state, 1, 0);
    }

    /**
     * 获取从0行0列开始的rowSize行colSize列的子矩阵
     * @param matrix
     * @param rowSize
     * @param colSize
     * @return
     */
    public static int[][] generateSubMatrix(int[][] matrix, int rowSize, int colSize) {
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        return result;
    }

    /**
     * 获取从0行0列开始的rowSize行colSize列的子矩阵
     * @param matrix
     * @param rowSize
     * @param colSize
     * @return
     */
    public static double[][] generateSubMatrix(double[][] matrix, int rowSize, int colSize) {
        double[][] result = new double[rowSize][colSize];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        return result;
    }

    public static Double[][] getSubMatrixByDeclaredRowList(Double[][] matrix, List<Integer> rowIndexList) {
        int resultRowSize = rowIndexList.size();
        int resultColSize = matrix[0].length;
        Double[][] result = new Double[resultRowSize][resultColSize];
        int k = 0;
        for (Integer tempRowIndex : rowIndexList) {
            for (int j = 0; j < resultColSize; j++) {
                result[k][j] = matrix[tempRowIndex][j];
            }
            ++k;
        }
        return result;
    }

    public static double[][] getSubMatrixByDeclaredRowList(double[][] matrix, List<Integer> rowIndexList) {
        int resultRowSize = rowIndexList.size();
        int resultColSize = matrix[0].length;
        double[][] result = new double[resultRowSize][resultColSize];
        int k = 0;
        for (int tempRowIndex : rowIndexList) {
            for (int j = 0; j < resultColSize; j++) {
                result[k][j] = matrix[tempRowIndex][j];
            }
            ++k;
        }
        return result;
    }
    public static Double[][] getSubMatrixByDeclaredColList(Double[][] matrix, List<Integer> colIndexList) {
        int resultRowSize = matrix.length;
        int resultColSize = colIndexList.size();
        Double[][] result = new Double[resultRowSize][resultColSize];
        int k = 0;
        for (Integer tempColIndex : colIndexList) {
            for (int i = 0; i < resultRowSize; i++) {
                result[i][k] = matrix[i][tempColIndex];
            }
            ++k;
        }
        return result;
    }

    public static double[][] getSubMatrixByDeclaredColList(double[][] matrix, List<Integer> colIndexList) {
        int resultRowSize = matrix.length;
        int resultColSize = colIndexList.size();
        double[][] result = new double[resultRowSize][resultColSize];
        int k = 0;
        for (int tempColIndex : colIndexList) {
            for (int i = 0; i < resultRowSize; i++) {
                result[i][k] = matrix[i][tempColIndex];
            }
            ++k;
        }
        return result;
    }

    /**
     * 对给定rowIndexList和colIndex的所在位置加上addingValue的值;
     * 如果colIndex小于0，则对所有列的给定行集合都加上addingValue
     * @param matrix
     * @param rowIndexList
     * @param colIndex
     * @param addingValue
     */
    public static void addValue(double[][] matrix, List<Integer> rowIndexList, Integer colIndex, double addingValue) {
        if (colIndex <= -1) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (Integer rowIndex : rowIndexList) {
                    matrix[rowIndex][j] += addingValue;
                }
            }
        } else {
            for (Integer rowIndex : rowIndexList) {
                matrix[rowIndex][colIndex] += addingValue;
            }
        }
    }

    /**
     * 对给定rowIndex和colIndexList的所在位置加上addingValue的值;
     * 如果rowIndex小于0，则对所有列的给定行集合都加上addingValue
     * @param matrix
     * @param rowIndex
     * @param colIndexList
     * @param addingValue
     */
    public static void addValue(double[][] matrix, Integer rowIndex, List<Integer> colIndexList, double addingValue) {
        if (rowIndex <= -1) {
            for (int i = 0; i < matrix.length; i++) {
                for (Integer colIndex : colIndexList) {
                    matrix[i][colIndex] += addingValue;
                }
            }
        } else {
            for (Integer colIndex : colIndexList) {
                matrix[rowIndex][colIndex] += addingValue;
            }
        }
    }

    /**
     * 对给定rowIndexList和colIndexList的所在位置加上addingValue的值
     * @param matrix
     * @param rowIndexList
     * @param colIndexList
     * @param addingValue
     */
    public static void addValue(double[][] matrix, List<Integer> rowIndexList, List<Integer> colIndexList, double addingValue) {
        for (Integer rowIndex : rowIndexList) {
            for (Integer colIndex : colIndexList) {
                matrix[rowIndex][colIndex] += addingValue;
            }
        }
    }

    /**
     * 对给定rowIndex和colIndex的所在位置加上addingValue的值;
     * 如果行标识小于0，则对所有行进行操作; 如果列标识小于0，则对所有列进行操作
     * @param matrix
     * @param rowIndex
     * @param colIndex
     * @param addingValue
     */
    public static void addValue(double[][] matrix, Integer rowIndex, Integer colIndex, double addingValue) {
        if (rowIndex <= -1 && colIndex <= -1) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] += addingValue;
                }
            }
        } else {
            if (colIndex <= -1) {
                for (int j = 0; j < matrix[rowIndex].length; j++) {
                    matrix[rowIndex][j] += addingValue;
                }
            } else if (rowIndex <= -1) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][colIndex] += addingValue;
                }
            } else {
                matrix[rowIndex][colIndex] += addingValue;
            }
        }
    }


    /**
     * 获取给定行中所有元素的最小值
     * @param matrix
     * @param rowIndex
     * @return
     */
    public static double getRowMinimalValue(double[][] matrix, Integer rowIndex) {
        Double result = Double.MAX_VALUE;
        for (int j = 0; j < matrix[rowIndex].length; j++) {
            if (matrix[rowIndex][j] < result) {
                result = matrix[rowIndex][j];
            }
        }
        return result;
    }

    /**
     * 获取给定列中所有元素的最小值
     * @param matrix
     * @param colIndex
     * @return
     */
    public static double getColMinimalValue(double[][] matrix, Integer colIndex) {
        Double result = Double.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][colIndex] < result) {
                result = matrix[i][colIndex];
            }
        }
        return result;
    }


    /**
     * 用给定的value生成给定行数和列数的矩阵
     * @param value
     * @param rowSize
     * @param colSize
     * @return
     */
    public static int[][] generateMatrixWithDeclaredValue(int value, int rowSize, int colSize) {
        int[][] matrix = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                matrix[i][j] = value;
            }
        }
        return matrix;
    }

    public static Double[][] getPairwiseSum(Double[][] dataA, Double[][] dataB) {
        Double[][] result = new Double[dataA.length][dataA[0].length];
        for (int i = 0; i < dataA.length; i++) {
            for (int j = 0; j < dataA[0].length; j++) {
                result[i][j] = dataA[i][j] + dataB[i][j];
            }
        }
        return result;
    }

    /**
     * 获取两个矩阵对应元素的乘积
     * @param dataA
     * @param dataB
     * @return
     */
    public static Double[][] getPairwiseMultiple(Double[][] dataA, Double[][] dataB) {
        int rowSize = dataA.length, colSize = dataA[0].length;
        if (dataB.length != rowSize || dataB[0].length != colSize) {
            throw new RuntimeException("The scales of dataA and dataB are not equal!");
        }
        Double[][] result = new Double[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                result[i][j] = dataA[i][j] * dataB[i][j];
            }
        }
        return result;
    }
    public static double[][] getPairwiseMultiple(double[][] dataA, double[][] dataB) {
        int rowSize = dataA.length, colSize = dataA[0].length;
        if (dataB.length != rowSize || dataB[0].length != colSize) {
            throw new RuntimeException("The scales of dataA and dataB are not equal!");
        }
        double[][] result = new double[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                result[i][j] = dataA[i][j] * dataB[i][j];
            }
        }
        return result;
    }

    /**
     * 矩阵右乘列向量
     * @param matrix
     * @param weight
     * @return
     */
    public static Double[] getVectorByRowSum(Double[][] matrix, Double[] weight) {
        if (weight.length != matrix[0].length) {
            throw new RuntimeException("Length does not match!");
        }
        Double[] result = new Double[matrix.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = BasicCalculation.getInnerProduct(matrix[i], weight);
        }
        return result;
    }
    public static double[] getVectorByRowSum(double[][] matrix, double[] weight) {
        if (weight.length != matrix[0].length) {
            throw new RuntimeException("Length does not match!");
        }
        double[] result = new double[matrix.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = BasicCalculation.getInnerProduct(matrix[i], weight);
        }
        return result;
    }
    public static void setVectorByRowSum(double[] result, double[][] matrix, double[] weight) {
        if (weight.length != matrix[0].length) {
            throw new RuntimeException("Length does not match!");
        }
//        double[] result = new double[matrix.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = BasicCalculation.getInnerProduct(matrix[i], weight);
        }
//        return result;
    }

    /**
     * 矩阵右乘单位列向量
     * @param matrix
     * @return
     */
    public static Double[] getVectorByRowSum(Double[][] matrix) {
        Double[] result = new Double[matrix.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = BasicCalculation.getSum(matrix[i]);
        }
        return result;
    }
    public static double[] getVectorByRowSum(double[][] matrix) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = BasicCalculation.getSum(matrix[i]);
        }
        return result;
    }
    public static void setVectorByRowSum(double[] result, double[][] matrix) {
//        double[] result = new double[matrix.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = BasicCalculation.getSum(matrix[i]);
        }
//        return result;
    }

    /**
     * 矩阵左乘行向量
     * @param matrix
     * @param weight
     * @return
     */
    public static Double[] getVectorByColSum(Double[][] matrix, Double[] weight) {
        if (weight.length != matrix.length) {
            throw new RuntimeException("Length does not match!");
        }
        Double[] result = new Double[matrix[0].length];
        for (int j = 0; j < result.length; j++) {
            result[j] = 0D;
            for (int i = 0; i < matrix.length; i++) {
                result[j] += matrix[i][j] * weight[i];
            }
        }
        return result;
    }
    public static double[] getVectorByColSum(double[][] matrix, double[] weight) {
        if (weight.length != matrix.length) {
            throw new RuntimeException("Length does not match!");
        }
        double[] result = new double[matrix[0].length];
        for (int j = 0; j < result.length; j++) {
            result[j] = 0D;
            for (int i = 0; i < matrix.length; i++) {
                result[j] += matrix[i][j] * weight[i];
            }
        }
        return result;
    }
    public static void setVectorByColSum(double[] result, double[][] matrix, double[] weight) {
        if (weight.length != matrix.length) {
            throw new RuntimeException("Length does not match!");
        }
//        double[] result = new double[matrix[0].length];
        for (int j = 0; j < result.length; j++) {
            result[j] = 0D;
            for (int i = 0; i < matrix.length; i++) {
                result[j] += matrix[i][j] * weight[i];
            }
        }
//        return result;
    }

    /**
     * 矩阵左乘单位行向量
     * @param matrix
     * @return
     */
    public static Double[] getVectorByColSum(Double[][] matrix) {
        Double[] result = new Double[matrix[0].length];
        for (int j = 0; j < result.length; j++) {
            result[j] = 0D;
            for (int i = 0; i < matrix.length; i++) {
                result[j] += matrix[i][j];
            }
        }
        return result;
    }
    public static double[] getVectorByColSum(double[][] matrix) {
        double[] result = new double[matrix[0].length];
        for (int j = 0; j < result.length; j++) {
            result[j] = 0D;
            for (int i = 0; i < matrix.length; i++) {
                result[j] += matrix[i][j];
            }
        }
        return result;
    }


    public static Double getSumFromGivenIndexSets(Double[][] numberArray, Collection<Integer> rowIndexSet, Collection<Integer> colIndexSet) {
        Double sum = 0.0;
        if(rowIndexSet == null || colIndexSet == null) {
            return sum;
        }
        for (Integer xIndex : rowIndexSet) {
            for (Integer yIndex : colIndexSet) {
                sum += numberArray[xIndex][yIndex];
            }
        }
        return sum;
    }

    public static Double getSumFromGivenIndexSets(Double[][] numberArray, Integer rowIndex, Collection<Integer> colIndexSet) {
        Double sum = 0.0;
        if (colIndexSet == null) {
            return sum;
        }
        for (Integer yIndex : colIndexSet) {
            sum += numberArray[rowIndex][yIndex];
        }
        return sum;
    }

    public static Double getSumFromGivenIndexSets(Double[][] numberArray, Collection<Integer> rowIndexSet, Integer colIndex) {
        Double sum = 0.0;
        if (rowIndexSet == null) {
            return sum;
        }
        for (Integer xIndex : rowIndexSet) {
            sum += numberArray[xIndex][colIndex];
        }
        return sum;
    }

    public static Double getSum(Double[][] numberArray) {
        Double sum = 0.0;
        for (int i = 0; i < numberArray.length; i++) {
            for (int j = 0; j < numberArray[0].length; j++) {
                sum += numberArray[i][j];
            }
        }
        return sum;
    }
    public static double getSum(double[][] numberArray) {
        double sum = 0.0;
        for (int i = 0; i < numberArray.length; i++) {
            for (int j = 0; j < numberArray[0].length; j++) {
                sum += numberArray[i][j];
            }
        }
        return sum;
    }

    /**
     * 不是直接提取第index行，而是复制第index行的所有元素
     * @param data
     * @param index
     * @return
     */
    public static Double[] getRowArray(Double[][] data, Integer index){
        Double[] result = new Double[data.length];
        for (int j = 0; j < result.length; j++) {
            result[j] = data[index][j];
        }
        return result;
    }
    public static Double[] getColArray(Double[][] data, Integer index) {
        Double[] result = new Double[data[0].length];
        for (int i = 0; i < result.length; i++) {
            result[i] = data[i][index];
        }
        return result;
    }

    public static Double[][] getMatrixProduct(Double[][] dataA, Double[][] dataB) {
        int dataAColSize = dataA[0].length, dataBRowSize = dataB.length;
        if (dataAColSize != dataBRowSize) {
            throw new RuntimeException("The colSize of dataA and the rowSize of dataB are not equal!");
        }
        int resultRowSize = dataA.length;
        int resultColSize = dataB[0].length;
        Double[] tempRowArray, tempColArray;
        Double[][] result = new Double[resultRowSize][resultColSize];
        for (int i = 0; i < resultRowSize; i++) {
            tempRowArray = getRowArray(dataA, i);
            for (int j = 0; j < resultColSize; j++) {
                tempColArray = getColArray(dataB, j);
                result[i][j] = BasicCalculation.getInnerProduct(tempRowArray, tempColArray);
            }
        }
        return result;
    }

    public static Double[][] getLeftMultipleDiagonalMatrix(Double[] diagonalArray, Double[][] data) {
        int leftMatrixSize = diagonalArray.length;
        if (leftMatrixSize != data.length) {
            throw new RuntimeException("The size of diagonal Array is not equal to the data length!");
        }
        Double[][] result = new Double[data.length][data[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = data[i][j] * diagonalArray[i];
            }
        }
        return result;
    }

    public static Double[][] getRightMultipleDiagonalMatrix(Double[][] data, Double[] diagonalArray) {
        int rightMatrixSize = diagonalArray.length;
        if (rightMatrixSize != data[0].length) {
            throw new RuntimeException("The size of diagonal Array is not equal to the data[0] length!");
        }
        Double[][] result = new Double[data.length][data[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = data[i][j] * diagonalArray[j];
            }
        }
        return result;
    }
    public static Double[] getAverageOfEachRow(double[][] data){
        Double[] result = new Double[data.length];
        BasicArrayUtil.setDoubleArrayToZero(result);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result[i] += data[i][j];
            }
            result[i] /= data[0].length;
        }
        return result;
    }





}
