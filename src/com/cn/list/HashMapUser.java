package com.cn.list;

import java.util.HashMap;
import java.util.Map;

public class HashMapUser {
    public static void main(String[] args){
        Map<Integer, String> m = new HashMap<>();
        m.put(1, "a");
        m.put(2, "b");
        System.out.println(m.get(2));

        Employee e1 = new Employee(1, "a", 5000);
        Employee e2 = new Employee(2, "b", 6000);
        Employee e3 = new Employee(3, "c", 7000);
        Map<Integer, Employee> n = new HashMap<>();
        n.put(1, e1);
        n.put(2, e2);
        n.put(3, e3);
        Employee m1 = n.get(3);
        System.out.println(m1.getName());
    }
}

class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
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
}
