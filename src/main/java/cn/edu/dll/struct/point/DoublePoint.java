package cn.edu.dll.struct.point;


import cn.edu.dll.basic.BasicArrayUtil;
import cn.edu.dll.basic.BasicCalculation;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public abstract class DoublePoint extends Point {
    protected Integer dimensionalSize = null;
    protected Double[] valueArray = null;

    public DoublePoint(Integer dimensionalSize) {
        this.dimensionalSize = dimensionalSize;
        this.valueArray = new Double[this.dimensionalSize];
        BasicArrayUtil.setDoubleArrayToZero(this.valueArray);
    }

    public DoublePoint(Double[] valueArray) {
        if (valueArray == null || valueArray.length < 1) {
            throw new RuntimeException("The parameter is not valid!");
        }
        this.dimensionalSize = valueArray.length;
        this.valueArray = valueArray;
    }

    public DoublePoint(double... values) {
        this.dimensionalSize = values.length;
        this.valueArray = new Double[this.dimensionalSize];
        for (int i = 0; i < this.dimensionalSize; i++) {
            this.valueArray[i] = values[i];
        }
    }


    public static <T extends DoublePoint> Double getMSE(List<T> estimationPointList, List<T> originalPointList) {
        int lenE = estimationPointList.size();
        int lenO = originalPointList.size();
        Double[] valueArrayA, valueArrayB;
        Double result = 0.0;
        if (lenE != lenO) {
            throw new RuntimeException("The size of two inputList is not equal!");
        }
        for (int i = 0; i < lenE; i++) {
            valueArrayA = estimationPointList.get(i).getValueArray();
            valueArrayB = originalPointList.get(i).getValueArray();
            result += BasicCalculation.getSquareValue(BasicCalculation.getDifference(valueArrayA, valueArrayB));
        }
        result /= lenE;
        return result;
    }


    @Override
    public Integer getDimensionalSize() {
        return dimensionalSize;
    }

    public Double[] getValueArray() {
        return valueArray;
    }

    public void setValueArray(Double[] valueArray) {
        if (valueArray == null || valueArray.length < 1) {
            throw new RuntimeException("The parameter is not valid!");
        }
        this.dimensionalSize = valueArray.length;
        this.valueArray = valueArray;
    }

    public void setValues(double... values) {
        if (values.length != this.dimensionalSize) {
            throw new RuntimeException("The number of values is not equaled to the dimension!");
        }
        for (int i = 0; i < this.dimensionalSize; i++) {
            this.valueArray[i] = values[i];
        }
    }

    @Override
    public double getDeclaredIndexValue(int dimensionIndex) {
        return this.valueArray[dimensionIndex];
    }

    public void setDeclaredIndexValue(int dimensionIndex, double value) {
        this.valueArray[dimensionIndex] = value;
    }

    @Override
    public String toString() {
        return "DoublePoint{" +
                "dimensionalSize=" + dimensionalSize +
                ", valueArray=" + Arrays.toString(valueArray) +
                '}';
    }

}
