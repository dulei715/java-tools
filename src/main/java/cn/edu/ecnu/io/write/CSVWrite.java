package cn.edu.ecnu.io.write;

import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;
import cn.edu.ecnu.struct.result.ColumnBean;

import java.io.IOException;
import java.util.*;

public class CSVWrite extends BasicWrite{
    public CSVWrite() {
        super(",");
    }


    /**
     *
     * @param data
     * @param tileList 必须和data中点map的键种类保持一致
     */
    public void write(List<Map<String, Object>> data, List<String> tileList) {
        if (tileList == null || tileList.size() == 0) {
            tileList = new ArrayList<>(data.get(0).keySet());
        }
        int columnSize = tileList.size();
        Map<String, Object> tempMap;
        try {
            this.bufferedWriter.write(tileList.get(0));
            for (int i = 1; i < columnSize; i++) {
                this.bufferedWriter.write(super.OUTPUT_SPLIT_SYMBOL);
                this.bufferedWriter.write(tileList.get(i));
            }
            this.bufferedWriter.newLine();
            for (int j = 0; j < data.size(); j++) {
                tempMap = data.get(j);
                this.bufferedWriter.write(String.valueOf(tempMap.get(tileList.get(0))));
                for (int i = 1; i < columnSize; i++) {
                    this.bufferedWriter.write(super.OUTPUT_SPLIT_SYMBOL);
                    this.bufferedWriter.write(String.valueOf(tempMap.get(tileList.get(i))));
                }
                this.bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public <T> void writeWithTileOrder(List<List<T>> data, List<String> tileList) {
        if (tileList == null || tileList.size() == 0) {
            throw new RuntimeException("The title is null!");
        }
        int columnSize = tileList.size();
        List<T> tempList;
        try {
            this.bufferedWriter.write(tileList.get(0));
            for (int i = 1; i < columnSize; i++) {
                this.bufferedWriter.write(super.OUTPUT_SPLIT_SYMBOL);
                this.bufferedWriter.write(tileList.get(i));
            }
            this.bufferedWriter.newLine();
            for (int j = 0; j < data.size(); j++) {
                tempList = data.get(j);
                this.bufferedWriter.write(String.valueOf(tempList.get(0)));
                for (int i = 1; i < columnSize; i++) {
                    this.bufferedWriter.write(super.OUTPUT_SPLIT_SYMBOL);
                    this.bufferedWriter.write(String.valueOf(tempList.get(i)));
                }
                this.bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeTwoDimensionalIntegerPointWithTileOrder(TreeMap<TwoDimensionalIntegerPoint, Double> data, List<String> tileList) {
        if (tileList == null || tileList.size() == 0) {
            throw new RuntimeException("The title is null!");
        }
        int columnSize = tileList.size();
        TwoDimensionalIntegerPoint tempPoint;
        try {
            this.bufferedWriter.write(tileList.get(0));
            for (int i = 1; i < columnSize; i++) {
                this.bufferedWriter.write(super.OUTPUT_SPLIT_SYMBOL);
                this.bufferedWriter.write(tileList.get(i));
            }
            this.bufferedWriter.newLine();

            for (Map.Entry<TwoDimensionalIntegerPoint, Double> tempEntry : data.entrySet()) {
                tempPoint = tempEntry.getKey();
                this.bufferedWriter.write(String.valueOf(tempPoint.getXIndex()));
                this.bufferedWriter.write(super.OUTPUT_SPLIT_SYMBOL);
                this.bufferedWriter.write(String.valueOf(tempPoint.getYIndex()));
                this.bufferedWriter.write(super.OUTPUT_SPLIT_SYMBOL);
                this.bufferedWriter.write(String.valueOf(tempEntry.getValue()));

                this.bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
