package com.rainbow.packge.ocl.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by xiaojc on 2016/6/29.
 * 功能:类反射 功能demo测试
 */
public class ClassReflectDemo {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        String str = "HH";
        ClassReflectDemo c= new ClassReflectDemo();

//        c.printClassName(str);


        Class<?> a = Class.forName("com.rainbow.packge.ocl.service.ClassReflectDemo");
//        System.out.println(a.getName());
        ClassReflectDemo d= (ClassReflectDemo) a.newInstance();
//        d.printClassName(str);

        /*String[] arr = new String[]{"1","2"};

        Method[] method = a.getMethods();
        System.out.println();*/

        Field ageField = a.getDeclaredField("age");
        int f = ageField.getModifiers();
        System.out.println("修饰符:"+ Modifier.toString(f));
        System.out.println("属性类型:"+  ageField.getType().getSimpleName());
        System.out.println("属性名字:"+  ageField.getName());


        ageField.set(d, 26);

        System.out.println("====>value:"+ ageField.get(d));


    }

    public void printClassName(Object obj) throws ClassNotFoundException {
        System.out.println("The class of " + obj + " is " + obj.getClass().getName());
        System.out.println("The class of " + obj + " is " + Class.forName("com.rainbow.packge.ocl.service.ClassReflectDemo"));
    }

}

class ChildDemo extends ClassReflectDemo{

    @Override
    public void printClassName(Object obj) throws ClassNotFoundException {
        super.printClassName(obj);
    }
}
