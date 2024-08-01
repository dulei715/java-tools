package cn.edu.dll.differential_privacy.ldp.frequency_oracle.foImp;


import cn.edu.dll.basic.BasicArrayUtil;
import cn.edu.dll.basic.RandomUtil;
import cn.edu.dll.collection.ListUtils;
import cn.edu.dll.cryptography.BoundedHashFunctionFamily;
import cn.edu.dll.cryptography.hash_function_impl.BoundedHashFunction;
import cn.edu.dll.differential_privacy.ldp.frequency_oracle.FrequencyOracle;
import cn.edu.dll.differential_privacy.ldp.frequency_oracle.basic_struct.HashFunctionResponsePair;

import java.util.ArrayList;
import java.util.List;

public class OptimizedIntegerLocalHashing implements FrequencyOracle<Integer, HashFunctionResponsePair> {

    protected Integer g = null;
    protected Integer[] inputDomainArray;
    protected Integer domainSize;
    public Integer[] hashFunctionIndexArray = null;
    public BoundedHashFunctionFamily hashFunctionFamily = null;
    public GeneralizedRandomizedResponse<Integer> gRR = null;

    public OptimizedIntegerLocalHashing(double epsilon, Integer[] inputDomainArray, int functionArraySize) {
        this.inputDomainArray = inputDomainArray;
        this.domainSize = this.inputDomainArray.length;
        this.g = (int) Math.round(Math.exp(epsilon) + 1);
        this.hashFunctionFamily = new BoundedHashFunctionFamily(functionArraySize, this.g);
        this.hashFunctionIndexArray = this.hashFunctionFamily.getFunctionIndexArray();
        this.gRR = new GeneralizedRandomizedResponse(epsilon, this.hashFunctionIndexArray);

    }


    //todo: design hash function first
    @Override
    public HashFunctionResponsePair<Integer> perturb(Integer rawData) {
        Integer hashFunctionIndex = RandomUtil.getRandomInteger(this.hashFunctionIndexArray[0], this.hashFunctionIndexArray[this.hashFunctionIndexArray.length - 1]);
        BoundedHashFunction hashFunction = this.hashFunctionFamily.getFunction(hashFunctionIndex);
        Integer hashValue = hashFunction.getHashValue(rawData);
//        Integer hashValue = this.hashFunctionFamily.getHashValue(hashFunctionIndex, rawData);
        Integer responseValue = this.gRR.perturb(hashValue);
        return new HashFunctionResponsePair(hashFunction, responseValue);
    }

    public static int getNoiseCountOfGivenValue(Integer rawValue, List<HashFunctionResponsePair<Integer>> responseList) {
        int result = 0;
        for (HashFunctionResponsePair<Integer> hashFunctionResponsePair : responseList) {
            if (hashFunctionResponsePair.getHashFunction().getHashValue(rawValue).equals(hashFunctionResponsePair.getResponseValue()))  {
                ++result;
            }
        }
        return result;
    }

    public List<Integer> getNoiseCountOfAllRawValues(List<HashFunctionResponsePair<Integer>> responseList) {
        List<Integer> noiseCountList = ListUtils.getSameElementList(0, this.domainSize);
        BoundedHashFunction hashFunction;
        Integer responseValue;
        Integer tempRawValue;
        for (HashFunctionResponsePair<Integer> response : responseList) {
            hashFunction = response.getHashFunction();
            responseValue = response.getResponseValue();
            for (int i = 0; i < this.inputDomainArray.length; ++i) {
                tempRawValue = inputDomainArray[i];
                if (hashFunction.getHashValue(tempRawValue).equals(responseValue)) {
                    noiseCountList.set(i, noiseCountList.get(i) + 1);
                    break;  // 这里假设每个response只贡献一个rawValue
                }
            }
        }
        return noiseCountList;
    }

    public List<Double> aggregateTotal(List<Integer> noiseEstimationCountList, int userSize) {
        List<Double> resultList = new ArrayList<>(noiseEstimationCountList.size());
        for (Integer noiseCount : noiseEstimationCountList) {
            resultList.add(aggregate(noiseCount, userSize));
        }
        return resultList;
    }

    @Override
    public double aggregate(int noiseEstimateCount, int userSize) {
        double inverseImageDomainSize = 1.0 / this.g;
        return (noiseEstimateCount * 1.0 / userSize - inverseImageDomainSize) / (this.gRR.getProbabilityP() - inverseImageDomainSize);
    }
}
