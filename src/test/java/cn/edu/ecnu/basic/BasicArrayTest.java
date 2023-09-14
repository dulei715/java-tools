package cn.edu.ecnu.basic;

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

    @Test
    public void fun5() {
        List<Integer> data = new ArrayList<>();
        data.add(3);
        MyPrint.showList(data);

        ListUtils.quickSort(data);
        MyPrint.showList(data);

    }

    @Test
    public void fun6() {
        List<Integer> data = new ArrayList<>();
        MyPrint.showList(data);

        ListUtils.quickSort(data);
        MyPrint.showList(data);

    }

    @Test
    public void fun7() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("aaaa", "bbbb");
        String cccc = treeMap.get("cccc");
        System.out.println(cccc);
//        String c = treeMap.get(null);
//        System.out.println(c);
    }

    @Test
    public void fun8() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.remove(new Integer(3));
        MyPrint.showList(list);
    }

    @Test
    public void fun9 () {
        double x1 = 6.0, x2 = 3.0;
        double y1 = 4.0, y2 = 8.0;
        double x = 4.0;
        double y = BasicArray.getLinearTransformValue(x1, x2, x, y1, y2);
        System.out.println(y);
    }

    @Test
    public void fun10() {
        double[] result = BasicArray.getIncreasedoubleNumberArray(3.0, 0.3, 5.1, 2);
        MyPrint.showDoubleArray(result);
    }


    @Test
    public void fun11() {
        double[] arrA = new double[20];
        double[] arrB = new double[20];
//        BasicArray.setDoubleArrayTo(arrA, 0);
//        BasicArray.setDoubleArrayTo(arrB, 0);
        double leftValue = 3.0, rightValue = 10.0;
        BasicArray.fillLinearTransformValue(leftValue, rightValue, arrA, 1, 4, true);
        BasicArray.fillLinearTransformValue(leftValue, rightValue, arrB, 1, 4, false);

        MyPrint.showDoubleArray(arrA);
        MyPrint.showDoubleArray(arrB);
    }


}
