package cn.edu.ecnu.statistic;

import cn.edu.dll.basic.BasicArrayUtil;
import cn.edu.dll.basic.BasicCalculation;
import cn.edu.dll.basic.RandomUtil;
import cn.edu.dll.collection.ListUtils;
import cn.edu.dll.constant_values.ConstantValues;
import cn.edu.dll.differential_privacy.ldp.frequency_oracle.basic_struct.HashFunctionResponsePair;
import cn.edu.dll.differential_privacy.ldp.frequency_oracle.foImp.OptimizedIntegerLocalHashing;
import cn.edu.dll.io.print.MyPrint;
import cn.edu.dll.statistic.StatisticTool;
import org.apache.commons.math3.stat.inference.BinomialTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OptimizedLocalHashingTest {
    @Test
    public void fun1() {
        int inputDomainSize = 1000;
        int hashBound = 100;
        int hashFunctionSize = 100;
        int userSize = 10000;
        double epsilon = 200.0;
        Integer[] inputDomain = BasicArrayUtil.getIncreaseIntegerNumberArray(0, 1, inputDomainSize - 1);
        TreeMap<Integer, Integer> userMap = new TreeMap<>();
        for (int i = 0; i < userSize; i++) {
            userMap.put(i, RandomUtil.getRandomInteger(0, inputDomainSize - 1));
        }
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        TreeMap<Integer, Double> countRatioMap = new TreeMap<>();
        for (Integer value : userMap.values()) {
            Integer count = countMap.getOrDefault(value, 0);
            ++count;
            countMap.put(value, count);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            countRatioMap.put(entry.getKey(), entry.getValue() * 1.0 / userSize);
        }
        MyPrint.showMap(countRatioMap, "; ");

        OptimizedIntegerLocalHashing optimizedLocalHashing = new OptimizedIntegerLocalHashing(epsilon, inputDomain, hashFunctionSize, hashBound);
        TreeMap<Integer, Integer> noiseUserMap = new TreeMap<>();
        List<HashFunctionResponsePair<Integer>> responseList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> userEntry : userMap.entrySet()) {
            Integer userValue = userEntry.getValue();
            HashFunctionResponsePair<Integer> perturbValue = optimizedLocalHashing.perturb(userValue);
            responseList.add(perturbValue);
        }
        TreeMap<Integer, Double> estimationMap = new TreeMap<>();
        for (Integer inputValue : inputDomain) {
            int noiseCount = optimizedLocalHashing.getNoiseCountOfGivenValue(inputValue, responseList);
            double tempEstimation = optimizedLocalHashing.aggregate(noiseCount, userSize);
            estimationMap.put(inputValue, tempEstimation);
        }
        MyPrint.showMap(estimationMap, "; ");

        List<Double> rawStatistic = new ArrayList<>();
        rawStatistic.addAll(countRatioMap.values());
        List<Double> estimateStatistic = new ArrayList<>();
        estimateStatistic.addAll(estimationMap.values());

        Double result = BasicCalculation.get2Norm(rawStatistic.toArray(new Double[0]), estimateStatistic.toArray(new Double[0]));
        System.out.println(result);

    }
}
