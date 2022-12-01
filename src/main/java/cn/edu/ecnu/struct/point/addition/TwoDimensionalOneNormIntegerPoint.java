package cn.edu.ecnu.struct.point.addition;


import cn.edu.ecnu.differential_privacy.cdp.basic_struct.DistanceAble;
import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.struct.pair.IdentityPair;
import cn.edu.ecnu.struct.point.IntegerPoint;
import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;

import java.util.*;

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
