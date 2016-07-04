package com.rainbow.packge.ocl.annotation;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by xiaojc on 2016/6/29.
 * 功能: 我的测试类
 */
@MyClassAnnotation(uri = "www.baidu.com", desc = "the class name")
public class MyTest {

    @MyConstuctorAnnotation(uri = "com.rainbow.packge.ocl.annotation.constuctor",desc = " the constuct name")
    public MyTest(){

    }

    @Greeting(fontColor = Greeting.FontColor.BLUE, name = "xxx")
    private String name;

    @MyConstuctorAnnotation(uri = "com.rainbow.packge.ocl.annotation.constuctor2",desc = " the constuct name2")
    public MyTest(int id){
        this.id = id;
    }

    @MyFieldAnnotation(uri="com.rainbow.packge.ocl.annotation.id", desc = " the filed name")
    private int id;

    @MyMthodAnnotation(uri = "com.rainbow.packge.ocl.annotation.getId", desc = "the method name")
    public int getId() {
        return id;
    }

    @MyMthodAnnotation(uri = "com.rainbow.packge.ocl.annotation.setId", desc = "the set method name")
    public void setId(int id) {
        this.id = id;
    }


    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Class<MyTest> clazz =  MyTest.class;

        //获取类注解
        MyClassAnnotation myClassAnnotation = clazz.getAnnotation(MyClassAnnotation.class);
        System.out.println("uri="+myClassAnnotation.uri() +" desc="+myClassAnnotation.desc());

        //获取构造器注解
        Constructor<MyTest> constructor =  clazz.getConstructor(new Class[]{});
        MyConstuctorAnnotation myConstuctorAnnotation = constructor.getAnnotation(MyConstuctorAnnotation.class);
        System.out.println("uri="+myConstuctorAnnotation.uri() +" desc="+myConstuctorAnnotation.desc());


        //获取构造器注解集合
        Constructor<MyTest>[] constructors = (Constructor<MyTest>[]) clazz.getConstructors();
        for (Constructor<MyTest> con : constructors){
            MyConstuctorAnnotation myConstuctorAnnotation1 = con.getAnnotation(MyConstuctorAnnotation.class);
            System.out.println("uri="+myConstuctorAnnotation1.uri() +" desc="+myConstuctorAnnotation1.desc());
        }

        //获取类方法注解
        Method method = clazz.getMethod("setId", new Class[]{int.class});
        MyMthodAnnotation myMthodAnnotation = method.getAnnotation(MyMthodAnnotation.class);
        System.out.println("uri="+myMthodAnnotation.uri() +" desc="+myMthodAnnotation.desc() + "方法返回类型："+method.getReturnType());

        Field field = clazz.getDeclaredField("id");
//        Field field = clazz.getField("id");
        MyFieldAnnotation myFieldAnnotation = field.getAnnotation(MyFieldAnnotation.class);
        System.out.println("uri="+myFieldAnnotation.uri() +" desc="+myFieldAnnotation.desc());


        Field nameField = clazz.getDeclaredField("name");
        Greeting greeting = nameField.getAnnotation(Greeting.class);
        System.out.println("===>"+greeting.fontColor());
    }
}
