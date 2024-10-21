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

    public static void main(String[] args) {
        Line line = new Line(-2, 1, -1);
        System.out.println(line);
        Line rollLine = line.roll(0, 0, Math.PI / 6);
        System.out.println(rollLine);

    }

}
