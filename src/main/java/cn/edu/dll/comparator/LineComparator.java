package cn.edu.dll.comparator;

import cn.edu.dll.geometry.Line;

import java.util.Comparator;

public class LineComparator implements Comparator<Line> {
    @Override
    public int compare(Line lineA, Line lineB) {
        double differ = lineA.getDirectAngle() - lineB.getDirectAngle();
        if (differ > 0) {
            return 1;
        } else if (differ < 0) {
            return -1;
        }
        double differ2 =  lineA.getParamC() - lineB.getParamC();
        if (differ2 > 0) {
            return 1;
        } else if (differ2 < 0) {
            return -1;
        }
        return 0;
    }
}
