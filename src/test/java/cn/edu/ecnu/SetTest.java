package cn.edu.ecnu;

import cn.edu.ecnu.io.print.MyPrint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SetTest {
    @Test
    public void fun1() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(2);
        treeSet.add(4);
        treeSet.add(7);
        treeSet.add(5);
        MyPrint.showCollection(treeSet);
        treeSet.remove(7);
        MyPrint.showCollection(treeSet);
        List list = new ArrayList(treeSet);
    }
}
