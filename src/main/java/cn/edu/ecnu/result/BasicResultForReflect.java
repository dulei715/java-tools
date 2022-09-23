package cn.edu.ecnu.result;

import cn.edu.ecnu.reflect.JavaBeanTool;
import cn.edu.ecnu.reflect.ReflectTool;
import cn.edu.ecnu.struct.result.ColumnBean;
import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Deprecated
public class BasicResultForReflect {
    private List<ColumnBean> attributeList = ResultTool.getAttributeListFromConfigureFile();

    private Class dynamicClassClass = null;
    private Object dynamicClassInstance = null;

    private BasicResultForReflect() {

    }

    public BasicResultForReflect getInstance() {
        BasicResultForReflect basicResult = new BasicResultForReflect();
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass;
        try {
//            String makeClassName = DynamicClass.class.getName();
            String makeClassName = "DynamicClass";
            ctClass = pool.makeClass(makeClassName);

//            String makeFieldStr = ReflectTool.getFieldDeclaredString("private", false, "String", "name");
//            String makeGetStr = ReflectTool.getGetMethodString("public", false, "String", "name");
//            String makeSetStr = ReflectTool.getSetMethodString("public", false, "String", "name");
//
//            ctClass.addField(CtField.make(makeFieldStr, ctClass));
//            ctClass.addMethod(CtMethod.make(makeGetStr, ctClass));
//            ctClass.addMethod(CtMethod.make(makeSetStr, ctClass));
            String fieldName, fieldType;
            String fieldStr, getterStr, setterStr;
            for (ColumnBean columnBean : basicResult.attributeList) {
                fieldName = columnBean.getName();
                fieldType = columnBean.getDataType();
                fieldStr = ReflectTool.getFieldDeclaredString("private", false, fieldType, fieldName);
                getterStr = ReflectTool.getGetMethodString("public", false, fieldType, fieldName);
                setterStr = ReflectTool.getSetMethodString("public", false, fieldType, fieldName);
                ctClass.addField(CtField.make(fieldStr, ctClass));
                ctClass.addMethod(CtMethod.make(getterStr, ctClass));
                ctClass.addMethod(CtMethod.make(setterStr, ctClass));


            }

            basicResult.dynamicClassClass = ctClass.toClass();
            basicResult.dynamicClassInstance = basicResult.dynamicClassClass.newInstance();
//            Field name = clazz.getDeclaredField("name");
//            System.out.println(name);
//            Method methodSet = clazz.getMethod("setName", String.class);
//            methodSet.invoke(basicResult.dynamicClassInstance, "duleilei");
//            Method methodGet = clazz.getMethod("getName");
//            Object result = methodGet.invoke(basicResult.dynamicClassInstance);
//            System.out.println(result);



        } catch (CannotCompileException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } 
        return basicResult;
    }

    public Object getFieldValue(String fieldName) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = this.dynamicClassClass.getMethod(JavaBeanTool.getGetMethodNameByFieldName(fieldName));
        return method.invoke(this.dynamicClassInstance);
    }



    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        BasicResultForReflect result = new BasicResultForReflect().getInstance();
        Object value = result.getFieldValue("DataSetName");
        System.out.println(value);
    }

}
