package cn.edu.dll.struct.point.addition;


import cn.edu.dll.struct.point.TwoDimensionalIntegerPoint;

@SuppressWarnings("ALL")
@Deprecated
public class TwoDimensionalOneNormIntegerPoint extends TwoDimensionalIntegerPoint  {


    @Override
    public Double getDistance(TwoDimensionalIntegerPoint element) {
        if (!(element instanceof TwoDimensionalOneNormIntegerPoint)) {
            throw new RuntimeException("Cannot compare type TwoDimensionalOnNormIntegerPoint with another type!");
        }
//        TwoDimensionalOneNormIntegerPoint newElement = (TwoDimensionalOneNormIntegerPoint) element;
        double xIndexDiffer = Math.abs(this.getXIndex() - element.getXIndex());
        double yIndexDiffer = Math.abs(this.getYIndex() - element.getYIndex());
        return xIndexDiffer + yIndexDiffer;
    }
}
