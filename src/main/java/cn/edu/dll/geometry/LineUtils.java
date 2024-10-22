package cn.edu.dll.geometry;

public class LineUtils {
    /**
     * 判断给定点是否在给定所有直线的同一侧（点是否在直线围成的图形内）
     * @param xIndex
     * @param yIndex
     * @param lines
     * @return
     */
    public static boolean isInnerGeo(double xIndex, double yIndex, Line... lines) {
        double tempA, tempB, tempC;
        int i;
        boolean judge;
//        lines[0].unifyXParamTag();
        tempA = lines[0].getParamA();
        tempB = lines[0].getParamB();
        tempC = lines[0].getParamC();
        judge = tempA * xIndex + tempB * yIndex + tempC <= 0;
        for (i = 1; i < lines.length; ++i) {
//            lines[i].unifyXParamTag();
            tempA = lines[i].getParamA();
            tempB = lines[i].getParamB();
            tempC = lines[i].getParamC();
            if (judge != (tempA * xIndex + tempB * yIndex + tempC <= 0)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取直线的法向量
     * @param line
     * @return
     */
    public static double[] getNormalVector(Line line) {
        return new double[]{line.getParamA(), line.getParamB()};
    }

    /**
     * 获取直线的方向向量
     * @param line
     * @return
     */
    public static double[] getDirectVector(Line line) {
        return new double[]{-line.getParamB(), line.getParamA()};
    }

    /**
     * 获取直线的方向角
     * @param line
     * @return
     */
    public static double getDirectAngle(Line line) {
        double[] directVector = getDirectVector(line);
        return Math.atan2(directVector[1], directVector[0]);
    }

    public static Line getRoll(Line originalLine, double xIndex, double yIndex, double thetaAngle) {
        double paramA, paramB, paramC;
        paramA = originalLine.getParamA();
        paramB = originalLine.getParamB();
        paramC = originalLine.getParamC();
        double newParamA = paramA * Math.cos(thetaAngle) - paramB * Math.sin(thetaAngle);
        double newParamB = paramA * Math.sin(thetaAngle) + paramB * Math.cos(thetaAngle);
        double newParamC = -newParamA * xIndex - newParamB * yIndex + paramC;
        return new Line(newParamA, newParamB, newParamC);
    }
}
