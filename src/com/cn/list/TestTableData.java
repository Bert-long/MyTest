package com.cn.list;

import java.util.*;
import java.util.ArrayList;

public class TestTableData {
    public static void main(String[] args) {
        User user1 = new User(1,"A",1000,"20200101");
        User user2 = new User(2,"B",2000,"20200101");
        User user3 = new User(3,"C",3000,"20200101");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        for (User u:list){
            System.out.println(u);
        }

        Map<Integer, User> map = new HashMap<>();
        map.put(1, user1);
        map.put(2, user2);
        map.put(3, user3);
        Set<Integer> keySet = map.keySet();
        for (Integer a:keySet){
            System.out.println(a +"--"+ map.get(a));
        }
    }
    /*
     * ORM思想：javabean表示一行数据，多个javabean放入map或者list中
     */
    public static void testTable1(){

    }
    /*
     * ORM思想：map表示一行数据，多个map放入List中
     */
    public static void testTable(){
        Map<String, Object> row1 = new HashMap<>();
        row1.put("id", 24);
        row1.put("name", "李白");
        row1.put("salary", 24000);
        row1.put("入职日期", 20200101);

        Map<String, Object> row2 = new HashMap<>();
        row2.put("id", 24);
        row2.put("name", "李白");
        row2.put("salary", 24000);
        row2.put("入职日期", 20200202);

        Map<String, Object> row3 = new HashMap<>();
        row3.put("id", 24);
        row3.put("name", "李白");
        row3.put("salary", 24000);
        row3.put("入职日期", 20200303);

        List<Map<String, Object>> table = new ArrayList<>();
        table.add(row1);
        table.add(row2);
        table.add(row3);
        for (Map<String, Object> row:table){
            Set<String> keySet = row.keySet();
            for (String key:keySet){
                System.out.print(key +":"+ row.get(key) + "\t");
            }
            System.out.println();
        }
    }

}

class User{
    private int id;
    private String name;
    private double salary;
    private String hireDate;

    //一个完整的javabean要有set和get方法，和一个无参构造器
    public User(){
    }
    public User(int id, String name, double salary, String hireDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }
}