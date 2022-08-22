package cn.edu.ecnu.basic;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    public static String concat(String split, Object ... objects) {
        int i = 0;
        String result = "";
        for (; i < objects.length - 1; i++) {
            result += objects[i] + split;
        }
        result += objects[i];
        return result;
    }

    public static String concat(String split, Double[] values){
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (; i < values.length - 1; i++) {
            stringBuilder.append(values[i]).append(split);
        }
        stringBuilder.append(values[i]);
        return stringBuilder.toString();
    }

    public static String[] getStringArray(String... strs) {
        String[] resultStringArray = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            resultStringArray[i] = strs[i];
        }
        return resultStringArray;
    }

    public static List<String> getStringList(String... strs) {
        List<String> resultStringList = new ArrayList<>(strs.length);
        for (String str : strs) {
            resultStringList.add(str);
        }
        return resultStringList;
    }

    public static void main(String[] args) {
        Double[] values = new Double[]{
                1.2, 4.2, 6.1
        };
        String result = concat(",", values);
        System.out.println(result);
    }

}
