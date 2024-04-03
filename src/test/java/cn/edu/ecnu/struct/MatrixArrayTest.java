package cn.edu.ecnu.struct;

import cn.edu.dll.basic.BasicCalculation;
import cn.edu.dll.basic.MatrixArray;
import cn.edu.dll.io.print.MyPrint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MatrixArrayTest {

    @Test
    public void fun1() {
        Double[][] dataA = new Double[][] {
                new Double[] {1D, 2D, 3D},
                new Double[] {4D, 5D, 6D},
                new Double[] {7D, 8D, 9D},
        };
        Double[][] dataB = new Double[][] {
                new Double[] {2D, 3D, 5D},
                new Double[] {7D, 11D, 4D},
                new Double[] {2D, 6D, 8D},
        };

        MyPrint.show2DimensionDoubleArray(dataA);
        MyPrint.showSplitLine("*", 150);

        MyPrint.show2DimensionDoubleArray(dataB);
        MyPrint.showSplitLine("*", 150);

        Double[][] result = MatrixArray.getMatrixProduct(dataA, dataB);
        MyPrint.show2DimensionDoubleArray(result);
        MyPrint.showSplitLine("*", 150);


    }

    @Test
    public void fun2() {
        Double[][] dataA = new Double[][] {
                new Double[] {1D, 2D, 3D},
                new Double[] {4D, 5D, 6D},
                new Double[] {7D, 8D, 9D},
        };
        Double[] array = new Double[] {
                3D, 5D, 7D
        };

        MyPrint.show2DimensionDoubleArray(dataA);
        MyPrint.showSplitLine("*", 150);

        Double[][] leftResult = MatrixArray.getLeftMultipleDiagonalMatrix(array, dataA);
        MyPrint.show2DimensionDoubleArray(leftResult);
        MyPrint.showSplitLine("*", 150);

        Double[][] rightResult = MatrixArray.getRightMultipleDiagonalMatrix(dataA, array);
        MyPrint.show2DimensionDoubleArray(rightResult);
        MyPrint.showSplitLine("*", 150);

    }

    @Test
    public void fun3() {
        List<List<Double>> data = new ArrayList<>();
        List<Double> tempData;
        for (int i = 0; i < 3; i++) {
            tempData = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                tempData.add(i*1.0+j);
            }
            data.add(tempData);
        }
        MyPrint.showList(data, ", ");

        Double[][] result = MatrixArray.toMatrixArray(data);
        MyPrint.show2DimensionDoubleArray(result);

    }
    @Test
    public void fun4() {
        List<List<Double>> data = new ArrayList<>();
        List<Double> tempData;
        for (int i = 0; i < 3; i++) {
            tempData = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                tempData.add(i*1.0+j);
            }
            data.add(tempData);
        }
//        MyPrint.showList(data, ", ");

        Double[][] result = MatrixArray.toMatrixArray(data);
        MyPrint.show2DimensionDoubleArray(result);
        MyPrint.showSplitLine("*", 150);

        List<Integer> indexList = new ArrayList<>();
        indexList.add(1);
        indexList.add(2);
        Double[][] subSetRowMatrix = MatrixArray.getSubMatrixByDeclaredRowList(result, indexList);
        Double[][] subSetColMatrix = MatrixArray.getSubMatrixByDeclaredColList(result, indexList);

        MyPrint.show2DimensionDoubleArray(subSetRowMatrix);
        MyPrint.showSplitLine("*", 150);
        MyPrint.show2DimensionDoubleArray(subSetColMatrix);
        MyPrint.showSplitLine("*", 150);

    }
    @Test
    public void fun5() {
        Double[][] matrix = new Double[2][3];
        MatrixArray.setValue(matrix, -1, -1, 0);
        Double[] data = new Double[]{1D,2D,3D};
        MatrixArray.setRowValueAsGivenVector(matrix, 0, data);
        MyPrint.show2DimensionDoubleArray(matrix);
    }



}
