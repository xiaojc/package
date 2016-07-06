package com.rainbow.commons.util;

import com.rainbow.commons.model.Email;
import com.rainbow.commons.model.Receiver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xiaojc on 2016/7/6.
 * 功能: java bean转xml /xml转java bean的工具处理类
 */
public class JAXBUtil {

    private static Map msgContextMap = new ConcurrentHashMap();
    private static Map objContextMap = new ConcurrentHashMap();
    private static Map toObjContextMap = new ConcurrentHashMap();

    public JAXBUtil() {
    }

    public static String toXML(Object obj) {
        if (obj == null) {
            return null;
        } else {
            return toXml(obj, "UTF-8");
        }
    }

    private static JAXBContext getObjContext(Class clz)
            throws RuntimeException {
        Object obj = objContextMap.get(clz);
        if (null == obj) {
            try {
                JAXBContext context = JAXBContext.newInstance(new Class[]{
                        clz
                });
                objContextMap.put(clz, context);
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }
        return (JAXBContext) objContextMap.get(clz);
    }

    private static JAXBContext getMsgContext(Class msgClz, Class clz)
            throws RuntimeException {
        Object obj = msgContextMap.get(clz);
        if (null == obj) {
            try {
                JAXBContext context = JAXBContext.newInstance(msgClz, clz);
                msgContextMap.put(clz, context);
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }
        return (JAXBContext) msgContextMap.get(clz);
    }

    private static JAXBContext getContextByClass(Class clz)
            throws RuntimeException {
        Object obj = toObjContextMap.get(clz);
        if (null == obj) {
            try {
                JAXBContext context = JAXBContext.newInstance(clz);
                toObjContextMap.put(clz, context);
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }
        return (JAXBContext) toObjContextMap.get(clz);
    }

    public static String toXml(Object obj, String encoding) {
        String result = null;
        try {
            JAXBContext context = getObjContext(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);// 编码格式
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);// 默认false表示xml指令存在
            //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Object toObject(String xml, Class messageDtoType, Class messageDtoObjectType) {
        if (xml == null || xml.length() == 0) {
            return null;
        }
        Object t = null;
        try {
            JAXBContext context = getMsgContext(messageDtoType, messageDtoObjectType);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static Object toObject(String xml, Class messageDtoType) {
        if (xml == null || xml.length() == 0) {
            return null;
        }
        Object t = null;
        try {
            JAXBContext context = getContextByClass(messageDtoType);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }


    public static void main(String[] args) {


        /*
        Receiver receiver = new Receiver("xjc_sun@163.com", 26);
        Email email = new Email(receiver, "标题", "正文");

        System.out.println(JAXBUtil.toXml(email, "utf-8"));*/

        String xmlStr = "<email><receiver><age>26</age><man>xjc_sun@163.com</man></receiver><content>正文</content><title>标题</title></email>";
        Email email = (Email) JAXBUtil.toObject(xmlStr, Email.class);
        System.out.println("===>name:"+email.getReceiver().getMan());

        System.out.println(JAXBUtil.toXml(email, "utf-8"));

    }
}
