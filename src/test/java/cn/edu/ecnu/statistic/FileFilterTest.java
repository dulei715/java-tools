package cn.edu.ecnu.statistic;

import cn.edu.dll.filter.file_filter.DirectoryFileFilter;
import cn.edu.dll.io.print.MyPrint;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

public class FileFilterTest {
    @Test
    public void fun1() {
        FileFilter fileFilter = new DirectoryFileFilter();
        String basicPath = "E:\\1.学习\\4.论文\\程鹏\\讨论补充\\github上传\\ResearchRecord\\ResearchRecord\\GroupMeeting\\0.individual_talk";
        File file = new File(basicPath);
        File[] files = file.listFiles(fileFilter);
        MyPrint.showArray(files);

    }
}
