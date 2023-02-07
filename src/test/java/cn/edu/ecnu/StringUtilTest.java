package cn.edu.ecnu;

import cn.edu.ecnu.basic.StringUtil;
import cn.edu.ecnu.constant_values.ConstantValues;
import org.junit.Test;

import java.lang.reflect.Method;

public class StringUtilTest {
    @Test
    public void fun1() {
        String split = ConstantValues.FILE_SPLIT;
        String result = StringUtil.join(split, "D:", "mypath", "wpaper1.bat");
        System.out.println(result);
    }

    @Test
    public void fum2() throws Exception {
        Class clazz = Class.forName("java.lang.String");
        Method method = clazz.getMethod("valueOf", String.class);
        Object result = method.invoke(null, "haha");
        System.out.println(result);
    }

    @Test
    public void fun3() {
        String.valueOf("haha");

    }
}
