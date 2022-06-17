package cn.edu.ecnu;

import cn.edu.ecnu.basic.BasicArray;
import cn.edu.ecnu.collection.ListUtils;
import cn.edu.ecnu.io.print.MyPrint;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class BasicArrayTest {
    @Test
    public void fun1() throws InstantiationException, IllegalAccessException {
        int size = 10;
        ArrayList<String>[] strListArray = new ArrayList[size];
        Class<ArrayList> clazz = ArrayList.class;
        BasicArray.setToEmptyGroup(strListArray, clazz);

        strListArray[1].add("xxx");
        MyPrint.showArray(strListArray);
    }

    @Test
    public void fun1_1() throws InstantiationException, IllegalAccessException {
        int size = 10;
        HashMap<String, Integer>[] strMapArray = new HashMap[size];
        Class<HashMap> clazz = HashMap.class;
        BasicArray.setToEmptyGroup(strMapArray, clazz);

        strMapArray[1].put("xxx", 20);
        MyPrint.showArray(strMapArray);
    }

    @Test
    public void fun2() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        int size = 10;
        ArrayList<String>[] strListArray = new ArrayList[size];
        Class<ArrayList> clazz = ArrayList.class;
        ArrayList<String> initList = new ArrayList<>();
        initList.add("aaa");
        initList.add("bbb");
        BasicArray.setGroupArrayTo(strListArray, initList, clazz);
        MyPrint.showArray(strListArray);
    }

    @Test
    public void fun3() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        int size = 10;
        LinkedList<String>[] strListArray = new LinkedList[size];
        Class<LinkedList> clazz = LinkedList.class;
        LinkedList<String> initList = new LinkedList<>();
        initList.add("aaa");
        initList.add("bbb");
        BasicArray.setGroupArrayTo(strListArray, initList, clazz);
        MyPrint.showArray(strListArray);
    }

    @Test
    public void fun2_2() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        int size = 10;
        HashMap<String, Integer>[] strMapArray = new HashMap[size];
        Class<HashMap> clazz = HashMap.class;
        HashMap<String, Integer> initMap = new HashMap<>();
        initMap.put("aaa", 10);
        initMap.put("bbb", 20);
        BasicArray.setGroupArrayTo(strMapArray, initMap, clazz);
        MyPrint.showArray(strMapArray);
    }

    @Test
    public void fun2_3() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        int size = 10;
        TreeMap<String, Integer>[] strMapArray = new TreeMap[size];
        Class<TreeMap> clazz = TreeMap.class;
        TreeMap<String, Integer> initMap = new TreeMap<>();
        initMap.put("aaa", 10);
        initMap.put("bbb", 20);
        BasicArray.setGroupArrayTo(strMapArray, initMap, clazz);
        MyPrint.showArray(strMapArray);
    }

    @Test
    public void fun4() {
        List<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(3);
        data.add(2);
        data.add(9);
        data.add(9);
        data.add(11);
        MyPrint.showList(data);

        ListUtils.quickSort(data);
        MyPrint.showList(data);

    }


}
