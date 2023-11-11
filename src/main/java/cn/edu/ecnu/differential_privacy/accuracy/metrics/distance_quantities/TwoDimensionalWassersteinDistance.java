package cn.edu.ecnu.differential_privacy.accuracy.metrics.distance_quantities;

import cn.edu.ecnu.basic.BasicCalculation;
import cn.edu.ecnu.basic.MatrixArray;
import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;
import edu.ecnu.dll.cpl.*;
import edu.ecnu.dll.cpl.expection.CPLException;
import struct.return_struct.CompressedDistributionAAndCompressedCouplingStruct;
import tools.others.Sinkhorn;
import tools.utils.SinkhornUtils;
//import tools.others.Sinkhorn;
//import tools.utils.SinkhornUtils;

import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

@SuppressWarnings("ALL")
public class TwoDimensionalWassersteinDistance {

    /**
     * 计算给定个的两个分布的wasserstein距离
     * @param distributionA 分布A，个数为 sizeA
     * @param distributionB 分布B，个数为 sizeB
     * @return
     */
    public static double getWassersteinDistanceByCPlex(TreeMap<TwoDimensionalIntegerPoint, Double> distributionA, TreeMap<TwoDimensionalIntegerPoint, Double> distributionB, Integer normP) throws CPLException {
        /**
         * 构建线性规划
         */
        CPlex cPlex = new CPlex();
        int sizeA = distributionA.size();
        int sizeB = distributionB.size();
        int variableSize = sizeA * sizeB;
        List<Variable> variableList = cPlex.addAndReturnVariableList(variableSize);

        Goal goal = new Goal();
        goal.setGoalType(GoalType.MIN);

        // 注意顺序
        Iterator<TwoDimensionalIntegerPoint> distributionAKeyIterator, distributionBKeyIterator;
        distributionAKeyIterator = distributionA.keySet().iterator();
        Integer[] pointAArrayValue, pointBArrayValue;
        switch (normP) {
            case 1:
                for (int i = 0, k = 0; i < sizeA; i++) {
                    pointAArrayValue = distributionAKeyIterator.next().getValueArray();
                    distributionBKeyIterator = distributionB.keySet().iterator();
                    for (int j = 0; j < sizeB; j++) {
                        pointBArrayValue = distributionBKeyIterator.next().getValueArray();
                        goal.putGoalElement(variableList.get(k), BasicCalculation.get1Norm(pointAArrayValue, pointBArrayValue) * 1.0);
                        ++k;
                    }
                }
                break;
            case 2:
                for (int i = 0, k = 0; i < sizeA; i++) {
                    pointAArrayValue = distributionAKeyIterator.next().getValueArray();
                    distributionBKeyIterator = distributionB.keySet().iterator();
                    for (int j = 0; j < sizeB; j++) {
                        pointBArrayValue = distributionBKeyIterator.next().getValueArray();
                        goal.putGoalElement(variableList.get(k), BasicCalculation.get2NormSquare(pointAArrayValue, pointBArrayValue) * 1.0);
                        ++k;
                    }
                }
                break;
        }
        cPlex.setGoal(goal);


        Constrain constrain;
        Iterator<Double> distributionValueIterator;

        distributionValueIterator = distributionA.values().iterator();
        for (int i = 0; i < sizeA; i++) {
            constrain = new Constrain();
            constrain.setConstrainTypeValue(ConstrainType.EQ);
            for (int j = 0; j < sizeB; j++) {
                constrain.putConstrainElement(variableList.get(i * sizeB + j), 1.0);
            }
            constrain.setRightValue(distributionValueIterator.next());
            cPlex.addConstrain(constrain);
        }

        distributionValueIterator = distributionB.values().iterator();
        for (int j = 0; j < sizeB; j++) {
            constrain = new Constrain();
            constrain.setConstrainTypeValue(ConstrainType.EQ);
            for (int i = 0; i < sizeA; i++) {
                constrain.putConstrainElement(variableList.get(i * sizeB + j), 1.0);
            }
            constrain.setRightValue(distributionValueIterator.next());
            cPlex.addConstrain(constrain);
        }
        cPlex.init();
        cPlex.solve();
        return Math.pow(cPlex.getResult(), 1.0 / normP);

    }




}
