package cn.edu.ecnu.basic;

import cn.edu.dll.basic.BasicCalculation;
import cn.edu.dll.collection.CollectionTools;
import cn.edu.dll.io.print.MyPrint;
import cn.edu.dll.struct.point.TwoDimensionalDoublePoint;
import cn.edu.dll.struct.point.TwoDimensionalDoublePointUtils;
import cn.edu.dll.struct.point.TwoDimensionalIntegerPoint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;

public class BasicCalculationTest {
    @Test
    public void fun1() {
        Double[] dataA = new Double[] {
                0.1, 0.2, 0.3, 0.4
        };
        Double[] dataB = new Double[] {
                0.5, 0.6, 0.7, 0.8
        };
        Double[] dataC = new Double[] {
                0.9, 1.0, 1.1, 1.2
        };
        Double[] result = BasicCalculation.getMultiwiseMultiple(dataA, dataB, dataC);
        MyPrint.showArray(result);
    }

    @Test
    public void fun2() {
        Double[] dataA = new Double[] {
                0.1, 0.2, 0.3, 0.4
        };
        Double[] dataB = new Double[] {
                0.5, 0.6, 0.7, 0.8
        };
        Double[] resultA = BasicCalculation.getPairwiseMultiple(dataA, 1, dataB, 1);
        MyPrint.showArray(resultA, ", ");
        Double[] resultB = BasicCalculation.getPairwiseMultiple(dataA, -1, dataB, 1);
        MyPrint.showArray(resultB, ", ");
        Double[] resultC = BasicCalculation.getPairwiseMultiple(dataA, 1, dataB, -1);
        MyPrint.showArray(resultC, ", ");
    }

    @Test
    public void fun3() {
        double result = BasicCalculation.getPrecisionValue(3.678, 2);
        System.out.println(result);
    }

    @Test
    public void intervalTest() {
        double[] intervalA = new double[]{3.5, 10.2};
        double[] intervalB = new double[]{4.5, 11.2};
        double[] result = BasicCalculation.getIntervalIntersection(intervalA, intervalB);
        MyPrint.showDoubleArray(result);
    }

    @Test
    public void fun4() {
        // 定义一个函数，接受一个整数并返回它的平方
        Function<Integer, Integer> squareFunction = x -> x * x;

        // 使用 apply 方法来计算 5 的平方
        Integer result = squareFunction.apply(5);
        System.out.println("Square of 5 is: " + result); // 输出：Square of 5 is: 25

        // 使用 andThen 方法，先求平方，然后加 10
        Function<Integer, Integer> addTenFunction = squareFunction.andThen(x -> x + 10);
        Integer result2 = addTenFunction.apply(5);
        System.out.println("Square of 5 plus 10 is: " + result2); // 输出：Square of 5 plus 10 is: 35

        // 使用 compose 方法，先加 10 再求平方
        Function<Integer, Integer> addAndSquareFunction = squareFunction.compose(x -> x + 10);
        Integer result3 = addAndSquareFunction.apply(5);
        System.out.println("5 plus 10 then square is: " + result3); // 输出：5 plus 10 then square is: 225

    }

    @Test
    public void fun5() {
        List<TwoDimensionalDoublePoint> data = new ArrayList<>();
        data.add(new TwoDimensionalDoublePoint(1, 1));
        data.add(new TwoDimensionalDoublePoint(-1, -1));
        data.add(new TwoDimensionalDoublePoint(-1, 2));
        data.add(new TwoDimensionalDoublePoint(2, 3));
        data.add(new TwoDimensionalDoublePoint(5, 10));
        List<TwoDimensionalDoublePoint> result = TwoDimensionalDoublePointUtils.getPointSubCollectionInGiven2NormDistanceRange(data, new TwoDimensionalDoublePoint(0, 0), 0.5, 0.1, 1.732, Math.sqrt(13));
        MyPrint.showList(result);
    }
}
