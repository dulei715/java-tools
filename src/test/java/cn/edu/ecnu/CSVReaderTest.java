package cn.edu.ecnu;

import cn.edu.ecnu.io.print.MyPrint;
import com.csvreader.CsvReader;
import org.junit.Test;

import java.io.*;

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
}
