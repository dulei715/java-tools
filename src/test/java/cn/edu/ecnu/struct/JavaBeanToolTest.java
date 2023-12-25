package cn.edu.ecnu.struct;

import cn.edu.dll.constant_values.ConstantValues;
import cn.edu.dll.io.print.MyPrint;
import cn.edu.dll.reflect.JavaBeanTool;
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
