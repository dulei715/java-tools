package cn.edu.ecnu;

import cn.edu.ecnu.constant_values.ConstantValues;
import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.result.BasicResult;
import cn.edu.ecnu.result.ExperimentResult;
import cn.edu.ecnu.result.ResultTool;
import cn.edu.ecnu.struct.result.ColumnBean;
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
