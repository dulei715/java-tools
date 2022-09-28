package cn.edu.ecnu;

import cn.edu.ecnu.constant_values.ConstantValues;
import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.result.ResultItem;
import cn.edu.ecnu.result.ResultTool;
import cn.edu.ecnu.struct.result.ColumnBean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ResultItemTest {
    @Test
    public void fun1() {
        String configName = "default";
        List<ColumnBean> attributeList = ResultTool.getAttributeListFromConfigureFile(configName);
//        ResultItem resultItem = new ResultItem();
//        MyPrint.showList(attributeList, ConstantValues.LINE_SPLIT);
        List<Object> valueList = new ArrayList<>();
        valueList.add("Crime");
        valueList.add(10);
        valueList.add(314.16);
        valueList.add(123456L);
        valueList.add(77);
        valueList.add(5);
        valueList.add(0.5);
        valueList.add(0.2);
        valueList.add(3.14);
        TreeMap<ColumnBean, Object> map = new TreeMap<>();
        for (int i = 0; i < attributeList.size(); i++) {
            map.put(attributeList.get(i), valueList.get(i));
        }


        MyPrint.showMap(map);
        MyPrint.showSplitLine("*", 120);


        List<Object> valueList2 = new ArrayList<>();
        valueList2.add("Crime");
        valueList2.add(20);
        valueList2.add(555.16);
        valueList2.add(2345L);
        valueList2.add(767);
        valueList2.add(56);
        valueList2.add(1.5);
        valueList2.add(3.2);
        valueList2.add(6.14);
        TreeMap map2 = new TreeMap<>();
        for (int i = 0; i < attributeList.size(); i++) {
            map2.put(attributeList.get(i), valueList2.get(i));
        }

        MyPrint.showMap(map2);
        MyPrint.showSplitLine("*", 120);

        ResultItem resultItemA = new ResultItem(map);
        ResultItem resultItemB = new ResultItem(map2);

        ResultItem plusResult = resultItemA.plus(resultItemB);
        TreeMap<ColumnBean, Object> mapCombine = plusResult.getItemData();
        MyPrint.showMap(mapCombine);

    }

    @Test
    public void fun2() {
        String configName = "default";
        List<ColumnBean> attributeList = ResultTool.getAttributeListFromConfigureFile(configName);
//        ResultItem resultItem = new ResultItem();
//        MyPrint.showList(attributeList, ConstantValues.LINE_SPLIT);
        List<String> valueList = new ArrayList<>();
        valueList.add("Crime");
        valueList.add("10");
        valueList.add("314.16");
        valueList.add("123456");
        valueList.add("77");
        valueList.add("5");
        valueList.add("0.5");
        valueList.add("0.2");
        valueList.add("3.14");




        List<String> valueList2 = new ArrayList<>();
        valueList2.add("Crime");
        valueList2.add("20");
        valueList2.add("555.16");
        valueList2.add("2345");
        valueList2.add("767");
        valueList2.add("56");
        valueList2.add("1.5");
        valueList2.add("3.2");
        valueList2.add("6.14");

//        ResultItem resultItemA = new ResultItem(map.size(), map);
//        ResultItem resultItemB = new ResultItem(map2.size(), map2);
        ResultItem resultItemA = ResultItem.toItem(attributeList, valueList);
        ResultItem resultItemB = ResultItem.toItem(attributeList, valueList2);

        ResultItem plusResult = resultItemA.plus(resultItemB);
        TreeMap<ColumnBean, Object> mapCombine = plusResult.getItemData();
        MyPrint.showMap(mapCombine);
    }
}
