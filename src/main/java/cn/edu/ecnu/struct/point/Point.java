package cn.edu.ecnu.struct.point;

public abstract class Point implements Cloneable {
    public abstract Integer getDimensionalSize();
    public abstract double getDeclaredIndexValue(int dimensionIndex);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
