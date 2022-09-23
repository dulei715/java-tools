package cn.edu.ecnu;

import cn.edu.ecnu.basic.StringUtil;
import cn.edu.ecnu.constant_values.ConstantValues;
import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.reflect.JavaBeanTool;
import org.junit.Test;

public class JavaBeanToolTest {
    @Test
    public void fun1() {
        String[] result = new String[] {
                JavaBeanTool.getGetMethodNameByFieldName("aa"),
                JavaBeanTool.getGetMethodNameByFieldName("aA"),
                JavaBeanTool.getGetMethodNameByFieldName("Aa"),
                JavaBeanTool.getGetMethodNameByFieldName("AA"),
                JavaBeanTool.getGetMethodNameByFieldName("a"),
                JavaBeanTool.getGetMethodNameByFieldName("A")
        };
        MyPrint.showArray(result, ConstantValues.LINE_SPLIT);


    }
}
