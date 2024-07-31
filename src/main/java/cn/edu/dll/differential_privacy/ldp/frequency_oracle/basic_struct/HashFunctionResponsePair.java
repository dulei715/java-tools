package cn.edu.dll.differential_privacy.ldp.frequency_oracle.basic_struct;


import cn.edu.dll.cryptography.HashFunction;

public class HashFunctionResponsePair<T> {
    private HashFunction hashFunction = null;
    private T responseValue = null;

    public HashFunctionResponsePair() {
    }

    public HashFunctionResponsePair(HashFunction hashFunction, T responseValue) {
        this.hashFunction = hashFunction;
        this.responseValue = responseValue;
    }

    public HashFunction getHashFunction() {
        return hashFunction;
    }

    public void setHashFunction(HashFunction hashFunction) {
        this.hashFunction = hashFunction;
    }

    public T getResponseValue() {
        return responseValue;
    }

    public void setResponseValue(T responseValue) {
        this.responseValue = responseValue;
    }
}
