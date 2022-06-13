package cn.edu.ecnu.struct;

import java.util.Objects;

public class SimpleTwoDimensionalPoint implements Comparable<SimpleTwoDimensionalPoint> {
    private Double xIndex;
    private Double yIndex;

    public SimpleTwoDimensionalPoint() {
        this.xIndex = 0.0;
        this.yIndex = 0.0;
    }

    public SimpleTwoDimensionalPoint(double xIndex, double yIndex) {
        this.xIndex = xIndex;
        this.yIndex = yIndex;
    }

    public SimpleTwoDimensionalPoint(double[] indexes) {
        this.xIndex = indexes[0];
        this.yIndex = indexes[1];
    }

    public static double getDistance(SimpleTwoDimensionalPoint simpleTwoDimensionalPointA, SimpleTwoDimensionalPoint simpleTwoDimensionalPointB) {
        double xDiff = simpleTwoDimensionalPointA.xIndex - simpleTwoDimensionalPointB.xIndex;
        double yDiff = simpleTwoDimensionalPointA.yIndex - simpleTwoDimensionalPointB.yIndex;
        return Math.sqrt(xDiff*xDiff+yDiff*yDiff);
    }

    public double getxIndex() {
        return xIndex;
    }

    public void setxIndex(double xIndex) {
        this.xIndex = xIndex;
    }

    public double getyIndex() {
        return yIndex;
    }

    public void setyIndex(double yIndex) {
        this.yIndex = yIndex;
    }

    public double[] getIndex() {
        return new double[]{this.xIndex, this.yIndex};
    }

    public static SimpleTwoDimensionalPoint valueOf(double xIndex, double yIndex) {
        return new SimpleTwoDimensionalPoint(xIndex, yIndex);
    }

    public void scalePosition(double factorK, double constA) {
        this.xIndex = this.xIndex * factorK + constA;
        this.yIndex = this.yIndex * factorK + constA;
    }

    @Override
    public String toString() {
        return "SimpleTwoDimensionalPoint{" +
                "xIndex=" + xIndex +
                ", yIndex=" + yIndex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleTwoDimensionalPoint simpleTwoDimensionalPoint = (SimpleTwoDimensionalPoint) o;
        return Double.compare(simpleTwoDimensionalPoint.xIndex, xIndex) == 0 &&
                Double.compare(simpleTwoDimensionalPoint.yIndex, yIndex) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xIndex, yIndex);
    }


    @Override
    public int compareTo(SimpleTwoDimensionalPoint simpleTwoDimensionalPoint) {
        if (this == simpleTwoDimensionalPoint) return 0;
        int xCMP = this.xIndex.compareTo(simpleTwoDimensionalPoint.xIndex);
        if (xCMP != 0) {
            return xCMP;
        }
        int yCMP = this.yIndex.compareTo(simpleTwoDimensionalPoint.yIndex);
        return yCMP;
    }
}
