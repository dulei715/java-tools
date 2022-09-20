package cn.edu.ecnu;

import cn.edu.ecnu.basic.StringUtil;
import cn.edu.ecnu.constant_values.ConstantValues;
import org.junit.Test;

public class StringUtilTest {
    @Test
    public void fun1() {
        String split = ConstantValues.FILE_SPLIT;
        String result = StringUtil.join(split, "D:", "mypath", "wpaper1.bat");
        System.out.println(result);
    }
}
