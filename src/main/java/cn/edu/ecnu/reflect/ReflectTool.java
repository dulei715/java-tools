package cn.edu.ecnu.reflect;

public class ReflectTool {


    public static String getFieldDeclaredString(String privilege, boolean isStatic, String fieldType, String fieldName) {
        StringBuilder stringBuilder = new StringBuilder();
        if (privilege != null) {
            stringBuilder.append(privilege);
            stringBuilder.append(" ");
        }
        if (isStatic) {
            stringBuilder.append("static").append(" ");
        }
        stringBuilder.append(fieldType).append(" ");
        stringBuilder.append(fieldName).append(";");
        return stringBuilder.toString();
    }

    public static String getGetMethodString(String privilege, boolean isStatic, String fieldType, String fieldName) {
        StringBuilder stringBuilder = new StringBuilder();
        if (privilege != null) {
            stringBuilder.append(privilege).append(" ");
        }
        if (isStatic) {
            stringBuilder.append("static").append(" ");
        }
        stringBuilder.append(fieldType).append(" ");
        stringBuilder.append(JavaBeanTool.getGetMethodNameByFieldName(fieldName)).append("()");
        stringBuilder.append("{return this." + fieldName + ";}");
        return stringBuilder.toString();
    }
    public static String getSetMethodString(String privilege, boolean isStatic, String fieldType, String fieldName) {
        StringBuilder stringBuilder = new StringBuilder();
        if (privilege != null) {
            stringBuilder.append(privilege).append(" ");
        }
        if (isStatic) {
            stringBuilder.append("static").append(" ");
        }
        stringBuilder.append("void").append(" ");
        stringBuilder.append(JavaBeanTool.getSetMethodNameByFieldName(fieldName));
        stringBuilder.append("(" + fieldType + " " + fieldName + ")");
        stringBuilder.append("{this." + fieldName + "=" + fieldName + ";}");
        return stringBuilder.toString();
    }

    public static String getSetMethodString() {
        return null;
    }

    public static void main(String[] args) {
        String word = getSetMethodString("public", false, "Integer", "name");
        System.out.println(word);
//        String word = getGetMethodString("public", false, "Integer", "name");
//        System.out.println(word);
//        String word = getFieldDeclaredString("public", false, "Integer", "name");
//        System.out.println(word);
    }


}
