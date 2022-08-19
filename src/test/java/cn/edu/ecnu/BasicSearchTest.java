package cn.edu.ecnu;

import cn.edu.ecnu.basic.BasicSearch;
import cn.edu.ecnu.io.print.MyPrint;
import org.junit.Test;

public class BasicSearchTest {
    @Test
    public void fun1() {
        Double[] pointValue = new Double[]{
                0.0, 0.1, 0.21, 0.35, 0.52, 0.77, 0.9
        };
        Double value = 0.12;
        Boolean former = BasicSearch.FORMER;
        Boolean latter = BasicSearch.LATTER;

        System.out.println(BasicSearch.binaryFormerSearchWithMinimalIndex(pointValue, value));
        System.out.println(BasicSearch.binaryLatterSearchWithMinimalIndex(pointValue, value));
        MyPrint.showSplitLine("*", 150);

        value = 0.21;
        System.out.println(BasicSearch.binaryFormerSearchWithMinimalIndex(pointValue, value));
        System.out.println(BasicSearch.binaryLatterSearchWithMinimalIndex(pointValue, value));
        MyPrint.showSplitLine("*", 150);

        value = 0.91;
        System.out.println(BasicSearch.binaryFormerSearchWithMinimalIndex(pointValue, value));
        System.out.println(BasicSearch.binaryLatterSearchWithMinimalIndex(pointValue, value));
        MyPrint.showSplitLine("*", 150);

        value = 0.0;
        System.out.println(BasicSearch.binaryFormerSearchWithMinimalIndex(pointValue, value));
        System.out.println(BasicSearch.binaryLatterSearchWithMinimalIndex(pointValue, value));
        MyPrint.showSplitLine("*", 150);

        value = -0.2;
        System.out.println(BasicSearch.binaryFormerSearchWithMinimalIndex(pointValue, value));
        System.out.println(BasicSearch.binaryLatterSearchWithMinimalIndex(pointValue, value));
        MyPrint.showSplitLine("*", 150);

        value = 0.35;
        System.out.println(BasicSearch.binaryFormerSearchWithMinimalIndex(pointValue, value));
        System.out.println(BasicSearch.binaryLatterSearchWithMinimalIndex(pointValue, value));
        MyPrint.showSplitLine("*", 150);

        value = 0.37;
        System.out.println(BasicSearch.binaryFormerSearchWithMinimalIndex(pointValue, value));
        System.out.println(BasicSearch.binaryLatterSearchWithMinimalIndex(pointValue, value));
        MyPrint.showSplitLine("*", 150);
    }
}
