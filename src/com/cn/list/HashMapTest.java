package com.cn.list;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class HashMapTest<K, V> {

    NodeTest1[] table; //位桶数组
    int size;           //存放键值对个数


    public HashMapTest(){
        table = new NodeTest1[16];
    }
    public static void main(String[] ages){
        //hashMap线程不安全，效率高,允许key,value为空。hashTable线程安全，效率低，不允许key,value为空
        Map<Integer, String> b = new Hashtable<>();
        HashMapTest<Integer, String> h = new HashMapTest<>();
        h.put(10,"a");
        h.put(20,"b");
        h.put(30,"c");
        h.put(30,"AAA");
        h.put(53,"TTT");
        h.put(69,"TGG");
        h.put(85,"KGG");
        System.out.println(h);
        System.out.println(h.get(53));


       /* //主要用于排序，按K值递增
        Map<Integer, String> a = new TreeMap<>();
        a.put(10, "a");
        a.put(20, "b");
        a.put(30, "c");
        for (Integer key:a.keySet()){
            System.out.println(key   +"--"+ a.get(key));
        }

        Map<Emp, String> c = new TreeMap<>();
        c.put(new Emp(1, "A", 1000), "AAAAAAAAAA");
        c.put(new Emp(2, "B", 2000), "BAAAAAAAAA");
        c.put(new Emp(3, "C", 3000), "CAAAAAAAAA");
        for (Emp key:c.keySet()){
            System.out.println(key +"---"+ c.get(key));
        }*/

    }

    static class Emp implements Comparable<Emp>{
        int id;
        String name;
        int salary;

        public Emp(int id, String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public int compareTo(Emp o){
            if (this.salary > o.salary){
                return 1;
            }else if (this.salary < o.salary){
                return -1;
            }else{
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public V get(K key){
        int hash = myHash(key.hashCode(), table.length);
        V value = null;
        if (table[hash] != null){
            NodeTest1<K, V> temp = table[hash];
            while (temp != null){
                if (temp.key.equals(key)){
                    value = temp.value;
                    break;
                }else{
                    temp = temp.next;
                }
            }
        }
        return value;
    }

    public void put(K key, V value){
        NodeTest1 node = new NodeTest1();
        node.hash = myHash(key.hashCode(), table.length);
        node.value = value;
        node.key = key;
        node.next = null;

        NodeTest1 temp = table[node.hash];
        NodeTest1 iterLast = null;
        boolean report = true;
        if (temp == null){
            table[node.hash] = node;
            size++;
        }else{
            while (temp != null){
                if (temp.key.equals(key)){
                    report = false;
                    System.out.println("Key重复");
                    temp.value = value;
                    break;
                }else{
                    iterLast = temp;
                    temp = temp.next;
                }
            }
            if (report) {
                iterLast.next = node;
                size++;
            }

        }

    }

    public int myHash(int v, int length){
//        System.out.println(v +"的HashCode值转换为Hash值：" + (v & (length - 1)));   //位运算，效率高
//        System.out.println(v +"的HashCode值转换为Hash值：" + (v % (length - 1)));   //取模运算，效率低
        return v & (length - 1);
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer("");
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null){
                s.append("第" + i + "行：" + table[i] + "\n");
            }else {
                s.append("第" + i + "行：[");
                while (table[i] != null){
                    s.append(table[i].key + "-" + table[i].value + ",");
                    table[i] = table[i].next;
                }
                s.setCharAt(s.length()-1,']');
                s.append("\n");
            }
        }
        return s.toString();
    }
}

class NodeTest1<K, V>{
    int hash;
    K key;
    V value;
    NodeTest1 next;
}

