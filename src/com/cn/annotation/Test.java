package com.cn.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.*;
import java.util.List;
import java.util.Map;

/**
 * 使用反射读取，模拟注解信息流程
 */
public class Test {
    public static void main(String[] args) {
//        test2();
        d();
    }

    public static void d(){
        try {
            //获得指定方法参数泛型信息
            Method m = Test.class.getMethod("test01", Map.class,List.class);
            Type[] t = m.getGenericParameterTypes();
            for (Type paramType : t) {
                System.out.println("#"+paramType);
                if(paramType instanceof ParameterizedType){
                    Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
                    for (Type genericType : genericTypes) {
                        System.out.println("泛型类型："+genericType);
                    }
                }
            }
            //获得指定方法返回值泛型信息
            Method m2 = Test.class.getMethod("test02", null);
            Type returnType = m2.getGenericReturnType();
            if(returnType instanceof ParameterizedType){
                Type[] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();

                for (Type genericType : genericTypes) {
                    System.out.println("返回值，泛型类型："+genericType);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void test01(Map<String,User> map, List<User> list){
        System.out.println("Demo04.test01()");
    }

    public Map<Integer,User> test02(){
        System.out.println("Demo04.test02()");
        return null;
    }
    //三种方式获取class对象
    public static void test2(){
        try {
            Class<?> c = Class.forName("com.cn.annotation.Student");
            System.out.println(c);

            Class str = String.class;
            Class str1 = "com.cn.annotation.Student".getClass();
            System.out.println(str == str1);

            int[] a = new int[10];
            int[] b = new int[30];
            int[][] cd = new int[30][10];
            System.out.println(a.getClass().hashCode());
            System.out.println(b.getClass().hashCode());
            System.out.println(cd.getClass().hashCode());

            //反射API调用构造方法
            Student s = (Student) c.newInstance();
            Constructor<Student> s1 = (Constructor<Student>) c.getDeclaredConstructor(int.class, String.class, int.class);
            System.out.println(s1.newInstance(1001,"123",1).getName());

            //调用普通方法
            Method method = c.getDeclaredMethod("setName",String.class);
            method.invoke(s, "你好");
            System.out.println(s.getName());

            //操作属性
            Field f = c.getDeclaredField("name");
            f.setAccessible(true); //属性不需要安全检查，直接访问
            f.set(s,"叶龙");
            System.out.println(s.getName());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    自定义的注解使用
    public static void test1(){
        try {
            Class c = Class.forName("com.cn.annotation.Student");
            //获取当前类所有注解
            Annotation[] annotations = c.getAnnotations();
            for (Annotation a:annotations) {
                System.out.println(a);
            }
            //获取注解信息
            Table s = (Table) c.getAnnotation(Table.class);
            System.out.println(s.value());
            //获取类属性的注解
            Field f = c.getDeclaredField("name");
            com.cn.annotation.Field f1 = f.getAnnotation(com.cn.annotation.Field.class);
            System.out.println(f1.columnName() + "--" + f1.type() + "-- "+ f1.length());

            //根据获得的信息，拼接DDL语句，生成SQL文，使用JDBC执行SQL，在数据库中生成表
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
