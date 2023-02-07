package cn.edu.ecnu.result;

import cn.edu.ecnu.basic.BasicArray;
import cn.edu.ecnu.io.read.BasicRead;
import cn.edu.ecnu.io.read.CSVRead;
import cn.edu.ecnu.io.write.BasicWrite;
import cn.edu.ecnu.io.write.CSVWrite;
import cn.edu.ecnu.reflect.ReflectTool;
import cn.edu.ecnu.struct.result.ColumnBean;
import org.checkerframework.checker.units.qual.C;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static void combineCSVFile(List<Map<String, Object>> originalData, List<Map<String, String>> newData, List<ColumnBean> columnBeanList) {

    }

    /**
     * 要保证所有文件的第一行一致，且和ColumnBean的name一致
     *
     * @param originalInputFilePath
     * @param outputFilePath
     * @param columnBeanList
     * @param composeType           只有sum和average两种，默认是sum
     * @return
     */
    public static void composeCSVFileWithTheSameFirstLine(String[] originalInputFilePath, String outputFilePath, List<ColumnBean> columnBeanList, Integer composeType) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        int length = originalInputFilePath.length;
        int columnNumber = columnBeanList.size();
        Map<String, String> tempMap;
        Map<String, Object> objectMap;
        ColumnBean columnBean;
        String tempType, tempName;
        Object objectValue, newObjectValue;
        List<Map<String, String>> tempData = CSVRead.readData(originalInputFilePath[0]);
        List<Map<String, Object>> resultData = BasicArray.getInitializedList(new HashMap(), tempData.size());

        for (int i = 0; i < columnNumber; i++) {
            columnBean = columnBeanList.get(i);
            tempType = columnBean.getDataType();
            tempName = columnBean.getName();
            for (int j = 0; j < tempData.size(); j++) {
                tempMap = tempData.get(j);
                objectValue = ReflectTool.getObjectWithGivenClassType(tempType, tempMap.get(tempName));
                objectMap = resultData.get(j);
                objectMap.put(tempName, objectValue);
            }
        }
        for (int k = 1; k < length; k++) {
            tempData = CSVRead.readData(originalInputFilePath[k]);
            for (int i = 0; i < columnNumber; i++) {
                columnBean = columnBeanList.get(i);
                if (!columnBean.isComposable()) {
                    continue;
                }
//                tempType = columnBean.getDataType();
                tempName = columnBean.getName();
                for (int j = 0; j < tempData.size(); j++) {
                    tempMap = tempData.get(j);
                    objectMap = resultData.get(j);
                    newObjectValue = tempMap.get(tempName);
                    objectValue = ReflectTool.combineObject(objectMap.get(tempName), newObjectValue);
                    objectMap.put(tempName, objectValue);
                }
            }
        }

        if (AVERAGE_COMPOSE.equals(composeType)) {
            for (int i = 0; i < columnNumber; i++) {
                columnBean = columnBeanList.get(i);
                if (!columnBean.isComposable()) {
                    continue;
                }
                tempName = columnBean.getName();
//                tempType = columnBean.getDataType();
                for (int j = 0; j < resultData.size(); j++) {
                    objectMap = resultData.get(j);
                    objectValue = ReflectTool.divide(objectMap.get(tempName), length);
                    objectMap.put(tempName, objectValue);
                }
            }
        }

        List<String> columnList = ColumnBean.getNameList(columnBeanList);
        CSVWrite csvWrite = new CSVWrite();
        csvWrite.startWriting(outputFilePath);
        csvWrite.write(resultData, columnList);
        csvWrite.endWriting();
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
