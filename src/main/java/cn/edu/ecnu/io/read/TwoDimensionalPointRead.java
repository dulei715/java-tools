package cn.edu.ecnu.io.read;


import cn.edu.ecnu.struct.point.DoublePoint;
import cn.edu.ecnu.struct.point.TwoDimensionalDoublePoint;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoDimensionalPointRead {

    public static final String SPLIT_TAG = " ";

    protected List<TwoDimensionalDoublePoint> pointList = null;
    protected String filePath;
    protected Integer dataSize = null;

    public TwoDimensionalPointRead(String filePath) {
        this.filePath = filePath;
    }

    /**
     * The first line should be the size of the dataset
     */
    public void readPointWithFirstLineCount(int scale) {
        BufferedReader bufferedReader = null;
        String line = null;
        String[] dataElement;
        int i = 0;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.filePath)));
            this.dataSize = Integer.valueOf(bufferedReader.readLine());
            this.pointList = new ArrayList<>(this.dataSize);
            while ((line = bufferedReader.readLine()) != null) {
                ++i;
                if (i % scale != 0) {
                    continue;
                }
                dataElement = line.split(SPLIT_TAG);
                this.pointList.add(new TwoDimensionalDoublePoint(Double.valueOf(dataElement[0]), Double.valueOf(dataElement[1])));
            }
//            if (!this.dataSize.equals(this.pointList.size())) {
//                throw new RuntimeException("The size of dataset is not inconsistent!");
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Integer readPointSizeWithFirstLineCount(String filePath) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            return Integer.valueOf(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void readPointWithFirstLineCount() {
        this.readPointWithFirstLineCount(1);
    }

    public static List<TwoDimensionalDoublePoint> readPointWithFirstLineCount(String filePath) {
        BufferedReader bufferedReader = null;
        String line = null;
        String[] dataElement;
        int dataSize;
        List<TwoDimensionalDoublePoint> pointList = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            dataSize = Integer.valueOf(bufferedReader.readLine());
            pointList = new ArrayList<>(dataSize);
            while ((line = bufferedReader.readLine()) != null) {
                dataElement = line.split(SPLIT_TAG);
                pointList.add(new TwoDimensionalDoublePoint(Double.valueOf(dataElement[0]), Double.valueOf(dataElement[1])));
            }
            if (dataSize != pointList.size()) {
                System.out.println(filePath + " error!");
                throw new RuntimeException("The size of dataset is not inconsistent!");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pointList;
    }

    public static List<DoublePoint> readTopKPointWithFirstLineCount(String filePath, int k) {
        BufferedReader bufferedReader = null;
        String line = null;
        String[] dataElement;
        int dataSize;
        List<DoublePoint> pointList = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            dataSize = Integer.valueOf(bufferedReader.readLine());
            pointList = new ArrayList<>(dataSize);
            int i = 0;
            while ((line = bufferedReader.readLine()) != null && i < k) {
                dataElement = line.split(SPLIT_TAG);
                pointList.add(new TwoDimensionalDoublePoint(Double.valueOf(dataElement[0]), Double.valueOf(dataElement[1])));
                ++i;
            }
            if (dataSize != pointList.size()) {
                throw new RuntimeException("The size of dataset is not inconsistent!");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pointList;
    }

    public List<TwoDimensionalDoublePoint> getPointList() {
        return pointList;
    }

    public String getFilePath() {
        return filePath;
    }

    public Integer getTotalDataSize() {
        return dataSize;
    }

    public Integer getRealDataSize() {
        return this.pointList.size();
    }

    /**
     * 规定：数据信息所在行(首行)为第-1行，具体第一条数据所在行为第0行.
     * @param filePath
     * @param lineNumberSet
     * @return
     */
    public static List<DoublePoint> readPointByDeclaredLines(String filePath, Set<Integer> lineNumberSet) {
        BasicRead basicRead = new BasicRead(SPLIT_TAG);
        basicRead.startReading(filePath);
        String line;
        Integer size = Integer.valueOf(basicRead.readOneLine());
        int dataLineNumber = -1;
        List<DoublePoint> pointList = new ArrayList<>(lineNumberSet.size());
        String[] lineData;
        while ((line = basicRead.readOneLine()) != null) {
            ++ dataLineNumber;
            if (!lineNumberSet.contains(dataLineNumber)) {
                continue;
            }
            lineData = line.split(SPLIT_TAG);
            pointList.add(TwoDimensionalDoublePoint.valueOf(Double.valueOf(lineData[0]), Double.valueOf(lineData[1])));
        }
        basicRead.endReading();
        return pointList;
    }

    public static Set<DoublePoint> readPointWithoutRepeat(String filePath) {
        BasicRead basicRead = new BasicRead(SPLIT_TAG);
        basicRead.startReading(filePath);
        String line;
        Integer size = Integer.valueOf(basicRead.readOneLine());
        Set<DoublePoint> pointSet = new HashSet<>();
        String[] lineData;
        while ((line = basicRead.readOneLine()) != null) {
            lineData = line.split(SPLIT_TAG);
            pointSet.add(TwoDimensionalDoublePoint.valueOf(Double.valueOf(lineData[0]), Double.valueOf(lineData[1])));
        }
        basicRead.endReading();
        return pointSet;
    }

    public static void main(String[] args) {
//        String filePath = "E:\\1.学习\\4.数据集\\dataset\\original\\chengdu_total_dataset_km\\total_dataset\\worker_point.txt";
//        String filePath = "E:\\1.学习\\4.数据集\\dataset\\original\\chengdu_total_dataset_km\\total_dataset\\task_point.txt";
        String filePath = "E:\\1.学习\\4.数据集\\dataset\\original\\chengdu_total_dataset_km\\batch_dataset\\batch_007_worker_point.txt";

        List<TwoDimensionalDoublePoint> allPointList = TwoDimensionalPointRead.readPointWithFirstLineCount(filePath);
        System.out.println(allPointList.size());

        Set<DoublePoint> allPointSet = TwoDimensionalPointRead.readPointWithoutRepeat(filePath);
        System.out.println(allPointSet.size());
    }
}
