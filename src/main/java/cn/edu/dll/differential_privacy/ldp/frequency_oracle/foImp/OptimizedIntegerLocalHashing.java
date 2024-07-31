package cn.edu.dll.differential_privacy.ldp.frequency_oracle.foImp;


import cn.edu.dll.basic.RandomUtil;
import cn.edu.dll.cryptography.BoundedHashFunctionFamily;
import cn.edu.dll.cryptography.hash_function_impl.BoundedHashFunction;
import cn.edu.dll.differential_privacy.ldp.frequency_oracle.FrequencyOracle;
import cn.edu.dll.differential_privacy.ldp.frequency_oracle.basic_struct.HashFunctionResponsePair;

import java.util.List;

public class OptimizedIntegerLocalHashing implements FrequencyOracle<Integer, HashFunctionResponsePair> {

    protected Integer g = null;
    protected Integer[] data = null;
    protected Integer[] inputDomainArray;
    protected Integer domainSize;
    public Integer[] hashFunctionIndexArray = null;
    public BoundedHashFunctionFamily hashFunctionFamily = null;
    public GeneralizedRandomizedResponse<Integer> gRR = null;

    public OptimizedIntegerLocalHashing(double epsilon, Integer[] inputDomainArray, int functionArraySize, int upperBound) {
        this.inputDomainArray = inputDomainArray;
        this.domainSize = this.inputDomainArray.length;
        this.g = upperBound;
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

    public int getNoiseCountOfGivenValue(Integer rawValue, List<HashFunctionResponsePair<Integer>> responseList) {
        int result = 0;
        for (HashFunctionResponsePair<Integer> hashFunctionResponsePair : responseList) {
            if (hashFunctionResponsePair.getHashFunction().getHashValue(rawValue).equals(hashFunctionResponsePair.getResponseValue()))  {
                ++result;
            }
        }
        return result;
    }

    @Override
    public double aggregate(int noiseEstimateCount, int userSize) {
        double inverseImageDomainSize = 1.0 / this.g;
        return (noiseEstimateCount * 1.0 / userSize - inverseImageDomainSize) / (this.gRR.getProbabilityP() - inverseImageDomainSize);
    }
}
