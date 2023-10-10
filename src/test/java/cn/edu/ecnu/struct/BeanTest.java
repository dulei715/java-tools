package cn.edu.ecnu.struct;

import cn.edu.ecnu.basic.StringUtil;
import cn.edu.ecnu.constant_values.ConstantValues;
import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.io.read.BasicRead;
import cn.edu.ecnu.io.read.BeanXMLRead;
import cn.edu.ecnu.struct.bean_structs.Bean;
import cn.edu.ecnu.struct.bean_structs.Beans;
import cn.edu.ecnu.struct.pair.BasicPair;
import cn.edu.ecnu.system.SystemTool;
import org.junit.Test;

import java.io.FileReader;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.util.List;

public class BeanTest {
    @Test
    public void fun1() {
        String projectPath = SystemTool.getProjectPath();
//        System.out.println(projectPath);
        String filePath = StringUtil.join(ConstantValues.FILE_SPLIT, projectPath, "src", "test","resources", "bean_test.xml");
//        System.out.println(filePath);
        Beans beans = BeanXMLRead.parseXML(filePath);
        List<Bean> beanList = beans.getBeanList();
        MyPrint.showList(beanList, ConstantValues.LINE_SPLIT);
    }
}
