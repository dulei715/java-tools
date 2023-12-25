package cn.edu.ecnu.statistic;

import cn.edu.dll.io.print.MyPrint;
import cn.edu.dll.io.read.CSVRead;
import cn.edu.dll.struct.point.TwoDimensionalIntegerPoint;
import com.csvreader.CsvReader;
import org.junit.Test;

import java.io.*;
import java.util.TreeMap;

public class CSVReaderTest {
    @Test
    public void fun1() throws IOException {
//        String path = "F:\\dataset\\crime\\Chicago_Crimes_2022_01_06.csv";
        String path = "E:\\1.学习\\4.数据集\\2.dataset_for_spatial_estimation\\crime\\Chicago_Crimes_2022_01_06.csv";
        File file = new File(path);

        CsvReader reader = new CsvReader(path, ',');
        int i = 0;
        while (reader.readRecord()) {
            ++i;
            if (i < 81390 || i > 81400) {
                continue;
            }
            MyPrint.showArray(reader.getValues());
            MyPrint.showSplitLine("*", 150);
        }



    }
    public void fun2() throws IOException {
        String path = "F:\\dataset\\crime\\Chicago_Crimes_2022_01_06.csv";
        File file = new File(path);

        CsvReader reader = new CsvReader(path, ',');
        while (reader.readRecord()) {

        }



    }

    @Test
    public void fun3() {
        String path = "E:\\1.学习\\4.数据集\\2.dataset_for_spatial_estimation\\test_dataset\\test_for_crime2_data_estimation_dam.txt";
        TreeMap<TwoDimensionalIntegerPoint, Double> result = CSVRead.readTwoDimensionalIntegerPointDistributionWithoutTitle(path);
        MyPrint.showMap(result);
    }
}
