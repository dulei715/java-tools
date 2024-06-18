package cn.edu.dll.basic;

public class NumberUtil {
    public static boolean isNumber(String str) {
        Double parseValue;
        try {
            parseValue = Double.parseDouble(str);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static void main(String[] args) {
        String dataA = "-23a";
        System.out.println(isNumber(dataA));
    }
}
