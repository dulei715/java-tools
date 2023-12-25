package cn.edu.ecnu.struct;

import cn.edu.dll.basic.StringUtil;
import cn.edu.dll.constant_values.ConstantValues;
import cn.edu.dll.io.print.MyPrint;
import cn.edu.dll.io.read.BeanXMLRead;
import cn.edu.dll.struct.bean_structs.Bean;
import cn.edu.dll.struct.bean_structs.Beans;
import cn.edu.dll.system.SystemTool;
import org.junit.Test;

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
