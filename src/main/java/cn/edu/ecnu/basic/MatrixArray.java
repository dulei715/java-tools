package cn.edu.ecnu.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MatrixArray {
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

    public static double getMatrixElementMultipleResult(double[][] matrix, int[][] state) {
        return getMatrixLinearChangeElementMultipleResult(matrix, state, 1, 0);
    }

    public static int[][] generateSubMatrix(int[][] matrix, int rowSize, int colSize) {
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        return result;
    }

    public static double[][] generateSubMatrix(double[][] matrix, int rowSize, int colSize) {
        double[][] result = new double[rowSize][colSize];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        return result;
    }

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

    public static void addValue(double[][] matrix, List<Integer> rowIndexList, List<Integer> colIndexList, double addingValue) {
        for (Integer rowIndex : rowIndexList) {
            for (Integer colIndex : colIndexList) {
                matrix[rowIndex][colIndex] += addingValue;
            }
        }
    }

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


    public static double getRowMinimalValue(double[][] matrix, Integer rowIndex) {
        Double result = Double.MAX_VALUE;
        for (int j = 0; j < matrix[rowIndex].length; j++) {
            if (matrix[rowIndex][j] < result) {
                result = matrix[rowIndex][j];
            }
        }
        return result;
    }

    public static double getColMinimalValue(double[][] matrix, Integer colIndex) {
        Double result = Double.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][colIndex] < result) {
                result = matrix[i][colIndex];
            }
        }
        return result;
    }

    public static List<Integer> getCombinedListOfTwoIntegerArray(int[] arrA, int[] arrB) {
        List<Integer> list = new ArrayList<>(arrA.length + arrB.length);
        for (int i = 0; i < arrA.length; i++) {
            list.add(arrA[i]);
        }
        for (int i = 0; i < arrB.length; i++) {
            list.add(arrB[i]);
        }
        return list;
    }

    public static int[][] generateMatrixWithDeclaredValue(int value, int rowSize, int colSize) {
        int[][] matrix = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                matrix[i][j] = value;
            }
        }
        return matrix;
    }

    public static void setArrayToDeclaredValueByIndexList(int[] arr, List<Integer> indexList, int value) {
        for (Integer index : indexList) {
            arr[index] = value;
        }
    }

    public static int getIndexOfMinimalValueGreaterThanDeclaredValue(List<Integer> data, Integer value) {
        Integer minimalValue = Integer.MAX_VALUE;
        int index = -1;
        Integer tempValue;
        for (int i = 0; i < data.size(); i++) {
            tempValue = data.get(i);
            if (tempValue > value && tempValue < minimalValue) {
                minimalValue = tempValue;
                index = i;
            }
        }
        return index;
    }

    public static double getMatrixLinearChangeElementMultipleResult(double[][] matrix, int[][] state, double paramMulti, double paramAdd) {
        double result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result += (matrix[i][j] * paramMulti + paramAdd) * state[i][j];
            }
        }
        return result;
    }

}
