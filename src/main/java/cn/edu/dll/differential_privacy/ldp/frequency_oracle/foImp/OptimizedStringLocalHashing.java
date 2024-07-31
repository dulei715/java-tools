package cn.edu.dll.differential_privacy.ldp.frequency_oracle.foImp;


import cn.edu.dll.cryptography.hash_function_impl.BoundedHashFunction;
import cn.edu.dll.differential_privacy.ldp.frequency_oracle.basic_struct.HashFunctionResponsePair;
import cn.edu.dll.basic.RandomUtil;
import cn.edu.dll.cryptography.BoundedHashFunctionFamily;
import cn.edu.dll.cryptography.HashFunction;
import cn.edu.dll.differential_privacy.ldp.frequency_oracle.FrequencyOracle;

public class OptimizedStringLocalHashing implements FrequencyOracle<String, HashFunctionResponsePair> {

    protected Integer g = null;
    protected String[] data = null;
    public Integer[] hashFunctionIndexArray = null;
    public BoundedHashFunctionFamily hashFunctionFamily = null;
    public GeneralizedRandomizedResponse<Long> gRR = null;

    public OptimizedStringLocalHashing(double epsilon, int functionArraySize, int upperBound) {
        this.g = upperBound;
        this.hashFunctionFamily = new BoundedHashFunctionFamily(functionArraySize, this.g);
        this.hashFunctionIndexArray = this.hashFunctionFamily.getFunctionIndexArray();
        this.gRR = new GeneralizedRandomizedResponse(epsilon, this.hashFunctionIndexArray);

    }


    //todo: design hash function first
    @Override
    public HashFunctionResponsePair perturb(String rawData) {
        Integer hashFunctionIndex = RandomUtil.getRandomInteger(this.hashFunctionIndexArray[0], this.hashFunctionIndexArray[this.hashFunctionIndexArray.length - 1]);
        BoundedHashFunction hashFunction = this.hashFunctionFamily.getFunction(hashFunctionIndex);
        Long hashValue = hashFunction.getHashValue(rawData);
        Long responseValue = this.gRR.perturb(hashValue);
        return new HashFunctionResponsePair(hashFunction, responseValue);
    }

    @Override
    public double aggregate(int targetNoiseEstimateCount, int userSize) {
        return 0;
    }
}
