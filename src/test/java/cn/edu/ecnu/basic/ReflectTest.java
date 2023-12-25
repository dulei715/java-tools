package cn.edu.ecnu.basic;

import cn.edu.dll.io.print.MyPrint;
import cn.edu.dll.reflect.ReflectTool;
import javassist.*;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    @Test
    public void fun1() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("cn.edu.ecnu.reflect.DynamicClass");
        ctClass.addField(new CtField(CtClass.intType, "age", ctClass));

        Class clazz = ctClass.toClass();
        Object obj = clazz.newInstance();
        Field age = clazz.getDeclaredField("age");
        System.out.println(age);
        age.setInt(obj, 28);
    }

    @Test
    public void fun2() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("cn.edu.ecnu.reflect.DynamicClass");
        ctClass.addField(CtField.make("private int age;", ctClass));

        Class clazz = ctClass.toClass();
        Object obj = clazz.newInstance();
        Field age = clazz.getDeclaredField("age");
        System.out.println(age);
        age.setInt(obj, 28);
    }

    @Test
    public void fun3() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("cn.edu.ecnu.reflect.DynamicClass");
//        ctClass.addField(CtField.make("public String name;", ctClass));
        String makeFieldStr = ReflectTool.getFieldDeclaredString("private", false, "String", "name");
        String makeGetStr = ReflectTool.getGetMethodString("public", false, "String", "name");
        String makeSetStr = ReflectTool.getSetMethodString("public", false, "String", "name");

        ctClass.addField(CtField.make(makeFieldStr, ctClass));
        ctClass.addMethod(CtMethod.make(makeGetStr, ctClass));
        ctClass.addMethod(CtMethod.make(makeSetStr, ctClass));

        Class clazz = ctClass.toClass();
        Object obj = clazz.newInstance();
        Field name = clazz.getDeclaredField("name");
        System.out.println(name);
//        name.set(obj, "duleilei");
        Method methodSet = clazz.getMethod("setName", String.class);
        methodSet.invoke(obj, "duleilei");
        Method methodGet = clazz.getMethod("getName");
        Object result = methodGet.invoke(obj);
        System.out.println(result);

    }

    @Test
    public void fun4() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Object result = ReflectTool.getObjectWithGivenClassType("java.lang.Double", "12");
        System.out.println(result.getClass().getName());
        System.out.println(result);
    }

    @Test
    public void fun5() {
        Double valueA = 10.4;
        String valueB = "20.2";
        Object result = ReflectTool.combineObject(valueA, valueB);
        System.out.println(result);
    }

    @Test
    public void fun6() {
        Double valueA = 0.0/0.0;
        System.out.println(valueA);
        Object[] objectArray = ReflectTool.filterNaNToGivenValue(valueA, "0");
        MyPrint.showArray(objectArray);
        Object[] objectArray2 = ReflectTool.filterNaNToGivenValue(23.3, "0");
        MyPrint.showArray(objectArray2);
    }

}
