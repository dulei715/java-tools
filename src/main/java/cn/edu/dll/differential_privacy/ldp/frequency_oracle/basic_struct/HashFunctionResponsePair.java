package cn.edu.dll.differential_privacy.ldp.frequency_oracle.basic_struct;


import cn.edu.dll.cryptography.HashFunction;
import cn.edu.dll.cryptography.hash_function_impl.BoundedHashFunction;

public class HashFunctionResponsePair<T> {
    private BoundedHashFunction hashFunction = null;
    private T responseValue = null;

    public HashFunctionResponsePair() {
    }

    public HashFunctionResponsePair(BoundedHashFunction hashFunction, T responseValue) {
        this.hashFunction = hashFunction;
        this.responseValue = responseValue;
    }

    public BoundedHashFunction getHashFunction() {
        return hashFunction;
    }

    public void setHashFunction(BoundedHashFunction hashFunction) {
        this.hashFunction = hashFunction;
    }

    public T getResponseValue() {
        return responseValue;
    }

    public void setResponseValue(T responseValue) {
        this.responseValue = responseValue;
    }
}
