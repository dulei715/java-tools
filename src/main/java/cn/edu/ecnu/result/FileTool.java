package cn.edu.ecnu.result;

import cn.edu.ecnu.io.read.BasicRead;
import cn.edu.ecnu.io.write.BasicWrite;
import cn.edu.ecnu.struct.result.ColumnBean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTool {

    private static File resultConfigFile = new File(FileTool.class.getResource("/").getPath(), "result_config.xml");
    public static final Integer SUM_COMPOSE = 1;
    public static final Integer AVERAGE_COMPOSE = 2;

    /**
     * 简单地合并，并不会识别键值对
     * @param originalInputFilePath
     * @param outputPath
     */
    public static void combineFilesWithTheSameFirstLine(String[] originalInputFilePath, String outputPath) {
        int length = originalInputFilePath.length;
        BasicRead basicRead = new BasicRead();
        List<String> resultData = new ArrayList<>();

        basicRead.startReading(originalInputFilePath[0]);
        resultData.addAll(basicRead.readStringStartFromGivenLine(0));
        basicRead.endReading();
        for (int i = 1; i < length; i++) {
            basicRead.startReading(originalInputFilePath[i]);
            resultData.addAll(basicRead.readStringStartFromGivenLine(1));
            basicRead.endReading();
        }
        BasicWrite basicWrite = new BasicWrite();
        basicWrite.startWriting(outputPath);
        basicWrite.writeSimpleStringListData(resultData);
        basicWrite.endWriting();
    }

    /**
     * 要保证所有文件的第一行一致，且和ColumnBean的name一致
     * @param originalInputFilePath
     * @param outputFilePath
     * @param columnBeanList
     * @param composeType 只有sum和average两种，默认是sum
     */
    public static void composeCSVFileWithTheSameFirstLine(String[] originalInputFilePath, String outputFilePath, List<ColumnBean> columnBeanList, Integer composeType) {
        int length = originalInputFilePath.length;
        BasicRead basicRead = new BasicRead();
        List<String> resultData = new ArrayList<>();
//        basicRead.startReading(originalInputFilePath[0]);
        for (int i = 0; i < length; i++) {
            basicRead.startReading(originalInputFilePath[i]);

        }
        //todo: 继续
    }

    public static String[] toStringArray(File[] fileArray) {
        int length = fileArray.length;
        String[] resultArray = new String[length];
        for (int i = 0; i < length; i++) {
            resultArray[i] = fileArray[i].getAbsolutePath();
        }
        return resultArray;
    }

    public static File[] toFileArray(String[] fileArray) {
        int length = fileArray.length;
        File[] resultArray = new File[length];
        for (int i = 0; i < length; i++) {
            resultArray[i] = new File(fileArray[i]);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        System.out.println(resultConfigFile.getPath());
    }
}
