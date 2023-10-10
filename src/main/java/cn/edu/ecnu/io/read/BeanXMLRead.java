package cn.edu.ecnu.io.read;

import cn.edu.ecnu.struct.bean_structs.Bean;
import cn.edu.ecnu.struct.bean_structs.Beans;
import cn.edu.ecnu.struct.bean_structs.Field;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class BeanXMLRead {

    public static Beans parseXML(String xmlFilePath) {
        Beans returnObjects = new Beans();
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
//            doc = DocumentHelper.parseText(xml);
            doc = reader.read(new File(xmlFilePath));
            Element root = doc.getRootElement();
            List elementList = root.elements();
            if (elementList != null && elementList.size() > 0) {
                for (int i = 0; i < elementList.size(); i++) {
                    Element objElement = (Element) elementList.get(i);
                    Bean obj = parseBean(objElement);
                    returnObjects.getBeanList().add(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnObjects;
    }


    public static Bean parseBean(Element objElement) {
        Bean bean = new Bean();
        bean.setClassName(objElement.attributeValue("className"));
        bean.setClassComment(objElement.attributeValue("classComment"));
        List listField = objElement.elements();
        if (listField != null && listField.size() > 0) {
            for (int i = 0; i < listField.size(); i++) {
                Element fieldElement = (Element) listField.get(i);
                Field field = parseField(fieldElement);
                bean.getListField().add(field);
            }
        }
        return bean;
    }

    private static Field parseField(Element fieldElement) {
        Field field = new Field();
        List attributeList = fieldElement.attributes();
        if (attributeList != null && attributeList.size() > 0) {
            for (int i = 0; i < attributeList.size(); i++) {
                Attribute fieldAttribute = (Attribute) attributeList.get(i);
                String key = fieldAttribute.getName();
                String value = fieldAttribute.getText();
                switch (key) {
                    case "name": field.setName(value); break;
                    case "type": field.setType(value); break;
                    case "comment": field.setComment(value); break;
                }
            }
        }
        return field;
    }

}
