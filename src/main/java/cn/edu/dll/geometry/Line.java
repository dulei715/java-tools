package cn.edu.dll.geometry;

public class Line implements Comparable<Line>{
    /**
     * 直线用一般式表示 Ax + By +C = 0
     */
    private double paramA;
    private double paramB;
    private double paramC;

    // 记录方向角
    private double directAngle;

    public Line(double paramA, double paramB, double paramC) {
        this.paramA = paramA;
        this.paramB = paramB;
        this.paramC = paramC;
        unifyXParamTag();
        this.directAngle = LineUtils.getDirectAngle(this);
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.paramA = y2 - y1;
        this.paramB = x1 - x2;
        this.paramC = x2 * y1 - x1 * y2;
        unifyXParamTag();
        this.directAngle = LineUtils.getDirectAngle(this);
    }

    /**
     * 将this.paramA设为正的e而不改变直线
     */
    private void unifyXParamTag() {
        if (this.paramA >= 0) {
            return;
        }
        this.paramA = -this.paramA;
        this.paramB = -this.paramB;
        this.paramC = -this.paramC;
    }





    public void roll(double xIndex, double yIndex, double thetaAngle) {
        double newParamA = this.paramA * Math.cos(thetaAngle) - this.paramB * Math.sin(thetaAngle);
        double newParamB = this.paramA * Math.sin(thetaAngle) + this.paramB * Math.cos(thetaAngle);
        double newParamC = -newParamA * xIndex - newParamB * yIndex + this.paramC;
        this.paramA = newParamA;
        this.paramB = newParamB;
        this.paramC = newParamC;
        unifyXParamTag();
        this.directAngle = LineUtils.getDirectAngle(this);
    }

    @Override
    public String toString() {
        return paramA + "x" + (paramB < 0 ? "" : "+") + paramB + "y" + (paramC < 0 ? "" : "+") + paramC + "=0";
    }

    public double getParamA() {
        return paramA;
    }

    public double getParamB() {
        return paramB;
    }


    public double getParamC() {
        return paramC;
    }

    public void setParamC(double paramC) {
        this.paramC = paramC;
    }

    public double getDirectAngle() {
        return directAngle;
    }


    @Override
    public int compareTo(Line lineB) {
        double differ = this.directAngle - lineB.directAngle;
        if (differ > 0) {
            return 1;
        } else if (differ < 0) {
            return -1;
        }
        double differ2 =  this.paramC - lineB.paramC;
        if (differ2 > 0) {
            return 1;
        } else if (differ2 < 0) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Line line = new Line(-2, 1, -1);
        double angle = Math.PI / 2;
        System.out.println(line);
        Line rollLine = LineUtils.getRoll(line,0, 0, angle);
        System.out.println(rollLine);

    }
}
