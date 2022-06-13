package cn.edu.ecnu.struct;

import cn.edu.ecnu.struct.point.Point;
import cn.edu.ecnu.struct.point.TwoDimensionalDoublePoint;

public class PolarPoint {
    protected Double radius = null;
    protected Double angle = null;

    public PolarPoint(Double radius, Double angle) {
        this.radius = radius;
        this.angle = angle;
    }

    public TwoDimensionalDoublePoint toPoint() {
        return TwoDimensionalDoublePoint.valueOf(this.radius * Math.cos(this.angle), this.radius * Math.sin(this.angle));
    }

    public static PolarPoint valueOf(Double radius, Double angle) {
        return new PolarPoint(radius, angle);
    }

}
