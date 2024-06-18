package cn.edu.dll.reflect;

import cn.edu.dll.configure.XMLConfigureUtils;
import cn.edu.dll.struct.bean_structs.Bean;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import java.lang.reflect.Method;
import java.util.List;

public class BeanUtils {
//    public static <T> T toBean(Element beanElement, Class<T> clazz) throws DocumentException, InstantiationException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
//        T instance = clazz.newInstance();
//        List<Element> list = beanElement.selectNodes("./field");
//        Method tempMethod;
//        String tempName, tempType;
//        String valueStr;
//        for (Element subElement : list) {
//            tempName = subElement.attributeValue("name");
//            tempType = subElement.attributeValue("type");
//            valueStr = subElement.getTextTrim();
//            tempMethod = clazz.getDeclaredMethod(JavaBeanTool.getSetMethodNameByFieldName(tempName), Class.forName(tempType));
//            tempMethod.invoke(instance, (tempType) ReflectTool.getObjectWithGivenClassType(tempType, valueStr));
//        }
//    }
}
