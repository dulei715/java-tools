package cn.edu.ecnu.io.write;


import cn.edu.ecnu.struct.point.Point;
import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("ALL")
public class PointWrite extends BasicWrite {

    public PointWrite() {
    }

    public PointWrite(String OUTPUT_SPLIT_SYMBOL) {
        super(OUTPUT_SPLIT_SYMBOL);
    }

    public void writePoint(Collection<? extends Point> dataCollection) {
        int i = 0;
        Point tempPoint;
        Integer pointDimensionSize;
        try {
            super.bufferedWriter.write(String.valueOf(dataCollection.size()));
            super.bufferedWriter.newLine();

            for (Point point : dataCollection) {
//                super.bufferedWriter.write(String.valueOf(point.getxIndex()));
//                super.bufferedWriter.write(super.OUTPUT_SPLIT_SYMBOL);
//                super.bufferedWriter.write(String.valueOf(point.getyIndex()));
                pointDimensionSize = point.getDimensionalSize();
                if (pointDimensionSize < 1) {
                    continue;
                }
                super.bufferedWriter.write(String.valueOf(point.getDeclaredIndexValue(0)));
                for (int j = 1; j < pointDimensionSize; j++) {
                    super.bufferedWriter.write(super.OUTPUT_SPLIT_SYMBOL);
                    super.bufferedWriter.write(String.valueOf(point.getDeclaredIndexValue(j)));
                }
                super.bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writePoint(List<Point> dataList, Set<Integer> declaredIndexSet) {
        Point point;
        Integer pointDimensionSize;
        try {
            super.bufferedWriter.write(String.valueOf(declaredIndexSet.size()));
            super.bufferedWriter.newLine();
            for (int i = 0; i < dataList.size(); i++) {
                if (!declaredIndexSet.contains(i)) {
                    continue;
                }
                point = dataList.get(i);
                pointDimensionSize = point.getDimensionalSize();
                if (pointDimensionSize < 1) {
                    continue;
                }
                super.bufferedWriter.write(String.valueOf(point.getDeclaredIndexValue(0)));
                for (int j = 1; j < pointDimensionSize; j++) {
                    super.bufferedWriter.write(super.OUTPUT_SPLIT_SYMBOL);
                    super.bufferedWriter.write(String.valueOf(point.getDeclaredIndexValue(j)));
                }
                super.bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writePoint(List<Point> dataList, Set<Integer> declaredIndexSet, double factorK, double constA) {
        Point point;
        Integer pointDimensionSize;
        try {
            super.bufferedWriter.write(String.valueOf(declaredIndexSet.size()));
            super.bufferedWriter.newLine();
            for (int i = 0; i < dataList.size(); i++) {
                if (!declaredIndexSet.contains(i)) {
                    continue;
                }
                point = dataList.get(i);
//                point.scalePosition(factorK, constA);
                pointDimensionSize = point.getDimensionalSize();
                if (pointDimensionSize < 1) {
                    continue;
                }
                super.bufferedWriter.write(String.valueOf(point.getDeclaredIndexValue(0)));
                for (int j = 1; j < pointDimensionSize; j++) {
                    super.bufferedWriter.write(super.OUTPUT_SPLIT_SYMBOL);
                    super.bufferedWriter.write(String.valueOf(point.getDeclaredIndexValue(j)));
                }
                super.bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeStatisticIntegerPoint(Map<TwoDimensionalIntegerPoint, Integer> dataCollection) {
        TwoDimensionalIntegerPoint tempPoint;
        Integer tempInteger;
        try {
            super.bufferedWriter.write(String.valueOf(dataCollection.size()));
            super.bufferedWriter.newLine();
            for (Map.Entry<TwoDimensionalIntegerPoint, Integer> entry : dataCollection.entrySet()) {
                tempPoint = entry.getKey();
                tempInteger = entry.getValue();
                super.bufferedWriter.write(tempPoint.getXIndex() + OUTPUT_SPLIT_SYMBOL);
                super.bufferedWriter.write(tempPoint.getYIndex() + OUTPUT_SPLIT_SYMBOL);
                super.bufferedWriter.write(String.valueOf(tempInteger));
                super.bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
