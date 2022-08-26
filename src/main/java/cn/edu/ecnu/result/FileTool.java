package cn.edu.ecnu.result;

import cn.edu.ecnu.io.read.BasicRead;
import cn.edu.ecnu.io.write.BasicWrite;

import java.util.ArrayList;
import java.util.List;

public class FileTool {
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

    public static void main(String[] args) {
        String[] pathArray = new String[]{
                "F:\\dataset\\test\\result\\crime\\crimeA\\alteringB.csv"
        };
        combineFilesWithTheSameFirstLine(pathArray, null);

    }
}
