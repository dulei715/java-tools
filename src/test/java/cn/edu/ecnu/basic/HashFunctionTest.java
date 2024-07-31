package cn.edu.ecnu.basic;

import cn.edu.dll.cryptography.hash_function_impl.SimpleHashFunction;
import cn.edu.dll.io.print.MyPrint;
import org.junit.Test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.TreeMap;

public class HashFunctionTest {
    @Test
    public void fun1() throws NoSuchAlgorithmException, InvalidKeyException {
        Integer key = 2;
        SimpleHashFunction hashFunction = new SimpleHashFunction(key, 10);
//        Integer result = hashFunction.getHashValue(13);
//        System.out.println(result);
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for (int i = 0; i < 200; i++) {
            Integer hashValue = hashFunction.getHashValue(i);
            int tempCount = countMap.getOrDefault(hashValue, 0);
            ++ tempCount;
            countMap.put(hashValue, tempCount);
        }
        MyPrint.showMap(countMap);
    }
}
