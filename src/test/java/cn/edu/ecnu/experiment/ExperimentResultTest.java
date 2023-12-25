package cn.edu.ecnu.experiment;

import cn.edu.dll.constant_values.ConstantValues;
import cn.edu.dll.io.print.MyPrint;
import cn.edu.dll.result.ResultTool;
import cn.edu.dll.struct.result.ColumnBean;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ExperimentResultTest {
    @Test
    public void fun1() throws InvocationTargetException, IllegalAccessException {
        List<ColumnBean> resultList = ResultTool.getAttributeListFromConfigureFile("default");
        MyPrint.showList(resultList, ConstantValues.LINE_SPLIT);
    }
}
