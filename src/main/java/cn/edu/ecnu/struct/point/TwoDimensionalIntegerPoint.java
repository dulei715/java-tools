package cn.edu.ecnu.struct.point;


import cn.edu.ecnu.differential_privacy.cdp.basic_struct.DistanceAble;
import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.struct.pair.IdentityPair;

import java.util.*;

@SuppressWarnings("ALL")
public class TwoDimensionalIntegerPoint extends IntegerPoint implements Comparable<TwoDimensionalIntegerPoint>, DistanceAble<TwoDimensionalIntegerPoint> {
    public TwoDimensionalIntegerPoint() {
        super(0,0);
    }

    public TwoDimensionalIntegerPoint(int xIndex, int yIndex) {
        super(xIndex, yIndex);
    }

    public TwoDimensionalIntegerPoint(int[] indexes) {
        super(indexes);
    }

    public TwoDimensionalIntegerPoint(Integer[] indexes) {
        super(indexes);
    }

    public TwoDimensionalIntegerPoint(IdentityPair<Integer> identityPair) {
        super(identityPair.getKey(), identityPair.getValue());
    }


    public Integer getXIndex() {
        return this.valueArray[0];
    }

    public void setXIndex(int xIndex) {
        this.valueArray[0] = xIndex;
    }

    public Integer getYIndex() {
        return valueArray[1];
    }

    public void setYIndex(int yIndex) {
        this.valueArray[1] = yIndex;
    }

    public int[] getIndex() {
        return new int[]{this.valueArray[0], this.valueArray[1]};
    }

    public static TwoDimensionalIntegerPoint valueOf(IntegerPoint point) {
        Integer[] indexes = point.getValueArray();
        return new TwoDimensionalIntegerPoint(indexes[0], indexes[1]);
    }

    public static List<TwoDimensionalIntegerPoint> valueOf(List<? extends IntegerPoint> pointList) {
        List<TwoDimensionalIntegerPoint> resultList = new ArrayList<>(pointList.size());
        for (int i = 0; i < pointList.size(); i++) {
            resultList.add(valueOf(pointList.get(i)));
        }
        return resultList;
    }

    @Override
    public String toString() {
        return "TwoDimensionalIntegerPoint{" +
                "xIndex=" + valueArray[0] +
                ", yIndex=" + valueArray[1] +
                '}';
    }

    public static TwoDimensionalIntegerPoint integerLinearCompose(TwoDimensionalIntegerPoint pointA, int paramA, TwoDimensionalIntegerPoint pointB, int paramB) {
        return new TwoDimensionalIntegerPoint(pointA.getXIndex() * paramA + pointB.getXIndex() * paramB, pointA.getYIndex() * paramA + pointB.getYIndex() * paramB);
    }

    @Override
    public int compareTo(TwoDimensionalIntegerPoint twoDimensionalIntegerPoint) {
        if (this == twoDimensionalIntegerPoint) return 0;
        int xCMP = this.valueArray[0].compareTo(twoDimensionalIntegerPoint.valueArray[0]);
        if (xCMP != 0) {
            return xCMP;
        }
        int yCMP = this.valueArray[1].compareTo(twoDimensionalIntegerPoint.valueArray[1]);
        return yCMP;
    }

    @Override
    public int hashCode() {
        //todo: 设计hashcode
        return this.valueArray[0].hashCode() * this.valueArray[1].hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TwoDimensionalIntegerPoint)) {
            return false;
        }
        TwoDimensionalIntegerPoint comparePoint = (TwoDimensionalIntegerPoint)obj;
        return (this.valueArray[0].equals(comparePoint.valueArray[0]) && this.valueArray[1].equals(comparePoint.valueArray[1]));
    }

    public static Collection<IdentityPair<Integer>> toIdentityPair(Collection<TwoDimensionalIntegerPoint> originalCollection) {
        TreeSet<IdentityPair<Integer>> resultSet = new TreeSet<>();
        for (TwoDimensionalIntegerPoint point : originalCollection) {
            resultSet.add(new IdentityPair<>(point.getXIndex(), point.getYIndex()));
        }
        return resultSet;
    }

    public IdentityPair<Integer> toIdentityPair() {
        return new IdentityPair<>(this.getXIndex(), this.getYIndex());
    }



    public static void main(String[] args) {
        TwoDimensionalIntegerPoint pointA = new TwoDimensionalIntegerPoint(2, 3);
        TwoDimensionalIntegerPoint pointB = new TwoDimensionalIntegerPoint(2, 3);
//        System.out.println(pointA.equals(pointB));
        Map<TwoDimensionalIntegerPoint, Integer> map = new HashMap<>();
        map.put(pointA, 2);
        MyPrint.showMap(map);
        MyPrint.showSplitLine("*", 100);
        map.put(pointB, 3);
        MyPrint.showMap(map);

        Integer a = 10;
        System.out.println(a.hashCode());
    }

    @Override
    public Double getDistance(TwoDimensionalIntegerPoint element) {
        double xIndexDiffer = this.getXIndex() - element.getXIndex();
        double yIndexDiffer = this.getYIndex() - element.getYIndex();
        return Math.sqrt(xIndexDiffer * xIndexDiffer + yIndexDiffer * yIndexDiffer);
    }
}
