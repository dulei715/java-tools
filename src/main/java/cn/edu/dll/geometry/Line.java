package cn.edu.dll.geometry;

public class Line {
    /**
     * 直线用一般式表示 Ax + By +C = 0
     */
    private double paramA;
    private double paramB;
    private double paramC;

    public Line(double paramA, double paramB, double paramC) {
        this.paramA = paramA;
        this.paramB = paramB;
        this.paramC = paramC;
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.paramA = y2 - y1;
        this.paramB = x1 - x2;
        this.paramC = x2 * y1 - x1 * y2;
    }

    /**
     * 将this.paramA设为正的e而不改变直线
     */
    public void unifyXParamTag() {
        if (this.paramA >= 0) {
            return;
        }
        this.paramA = -this.paramA;
        this.paramB = -this.paramB;
        this.paramC = -this.paramC;
    }

    public Line roll(double xIndex, double yIndex, double thetaAngle) {
        double newParamA = this.paramA * Math.cos(thetaAngle) - this.paramB * Math.sin(thetaAngle);
        double newParamB = this.paramA * Math.sin(thetaAngle) + this.paramB * Math.cos(thetaAngle);
        double newParamC = -newParamA * xIndex - newParamB * yIndex;
        return new Line(newParamA, newParamB, newParamC);
    }

    @Override
    public String toString() {
        return paramA + "x" + (paramB < 0 ? "" : "+") + paramB + "y" + (paramC < 0 ? "" : "+") + paramC + "=0";
    }

    public double getParamA() {
        return paramA;
    }

    public void setParamA(double paramA) {
        this.paramA = paramA;
    }

    public double getParamB() {
        return paramB;
    }

    public void setParamB(double paramB) {
        this.paramB = paramB;
    }

    public double getParamC() {
        return paramC;
    }

    public void setParamC(double paramC) {
        this.paramC = paramC;
    }

    public static void main(String[] args) {
        Line line = new Line(-2, 1, -1);
        System.out.println(line);
        Line rollLine = line.roll(0, 0, Math.PI / 6);
        System.out.println(rollLine);

    }

}
