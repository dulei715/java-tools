package cn.edu.ecnu.statistic;

import cn.edu.ecnu.io.write.PointWrite;
import cn.edu.ecnu.struct.pair.BasicPair;
import cn.edu.ecnu.struct.point.TwoDimensionalDoublePoint;
import cn.edu.ecnu.struct.point.TwoDimensionalDoublePointUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ClusterTest {
    @Test
    public void fun1() {



        List<BasicPair<Double, Double>> data = new ArrayList<>();
        data.add(new BasicPair<>(1.2, 3.4));
        data.add(new BasicPair<>(2.2, 1.4));
        data.add(new BasicPair<>(3.3, 7.2));
        data.add(new BasicPair<>(6.2, 5.1));

        data.add(new BasicPair<>(10.2, 13.4));
        data.add(new BasicPair<>(11.2, 17.4));
        data.add(new BasicPair<>(15.3, 12.2));
        data.add(new BasicPair<>(18.2, 16.1));

        data.add(new BasicPair<>(22.2, 3.4));
        data.add(new BasicPair<>(25.2, 8.4));
        data.add(new BasicPair<>(27.3, 4.2));
        data.add(new BasicPair<>(21.2, 6.1));

        List<Integer> indexList = Cluster.kMeansToGivenPoints(data, 3, 0.000001);
        List<BasicPair<Double,Double>> chosenDataList = new ArrayList<>();
        for (int i = 0; i < indexList.size(); i++) {
            chosenDataList.add(data.get(indexList.get(i)));
            System.out.println(chosenDataList.get(i));
        }


        List<TwoDimensionalDoublePoint> twoDimensionalDoublePointList = TwoDimensionalDoublePointUtils.parsePoint(data);
        List<TwoDimensionalDoublePoint> chosenList = TwoDimensionalDoublePointUtils.parsePoint(chosenDataList);
        String outputFileName = "E:\\1.学习\\4.数据集\\test\\data.txt";
        PointWrite pointWrite = new PointWrite();
        pointWrite.startWriting(outputFileName);
//        pointWrite.writeListDataWithNewLineSplit(twoDimensionalDoublePointList);
        pointWrite.writePoint(twoDimensionalDoublePointList);
        pointWrite.writePoint(chosenList);
        pointWrite.endWriting();
    }


    @Test
    public void fun2() {

        List<BasicPair<Double, Double>> data = new ArrayList<>();
        data.add(new BasicPair<>(1.2, 3.4));
        data.add(new BasicPair<>(2.2, 1.4));
        data.add(new BasicPair<>(3.3, 7.2));
        data.add(new BasicPair<>(6.2, 5.1));

        data.add(new BasicPair<>(10.2, 13.4));
        data.add(new BasicPair<>(11.2, 17.4));
        data.add(new BasicPair<>(15.3, 12.2));
        data.add(new BasicPair<>(18.2, 16.1));

        data.add(new BasicPair<>(22.2, 3.4));
        data.add(new BasicPair<>(25.2, 8.4));
        data.add(new BasicPair<>(27.3, 4.2));
        data.add(new BasicPair<>(21.2, 6.1));

        TreeSet<Integer> initialIndexSet = new TreeSet<>();
        initialIndexSet.add(0);
        initialIndexSet.add(4);
        initialIndexSet.add(8);

        List<Integer> indexList = Cluster.kMeansToGivenPointsByGivenSpecificPoints(data, initialIndexSet, 0.000001);
        List<BasicPair<Double,Double>> chosenDataList = new ArrayList<>();
        for (int i = 0; i < indexList.size(); i++) {
            chosenDataList.add(data.get(indexList.get(i)));
            System.out.println(chosenDataList.get(i));
        }


        List<TwoDimensionalDoublePoint> twoDimensionalDoublePointList = TwoDimensionalDoublePointUtils.parsePoint(data);
        List<TwoDimensionalDoublePoint> chosenList = TwoDimensionalDoublePointUtils.parsePoint(chosenDataList);
        String outputFileName = "E:\\1.学习\\4.数据集\\test\\data2.txt";
        PointWrite pointWrite = new PointWrite();
        pointWrite.startWriting(outputFileName);
//        pointWrite.writeListDataWithNewLineSplit(twoDimensionalDoublePointList);
        pointWrite.writePoint(twoDimensionalDoublePointList);
        pointWrite.writePoint(chosenList);
        pointWrite.endWriting();
    }
}
