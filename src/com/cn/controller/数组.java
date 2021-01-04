package com.cn.controller;

import java.util.Arrays;

public class 数组 {
    public static void main(String args[]) {
       /* int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        int[] b = {1,2,3,34,45,56};
        System.out.println("\n" + b[5]);
        for(int i:b){
            System.out.println(i);
        }*/

//        数组复制
        String[] e = {"a", "b", "c", "d", "e"};
        int[] b = {1, 2, 3, 34, 45, 56};
  /*     e的起始位置复制到d的起始位置，最后是复制长度
        System.arraycopy(e,2,e,3,1);
        removeElment(e, 3);
        removeT(e, 2, 4 );
        for(String i:e){
            System.out.println(i);
        }*/
        System.out.println();
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));

        /*二维数组
        int[][] a = new int[3][];
        a[0] = new int[]{20, 30, 40};
        a[1] = new int[]{2, 3, 4};
        a[2] = new int[]{20, 30};

        int[][] c = {
                {20, 30, 40},
                {2, 3, 4},
                {2}
        };
        System.out.println(c[0][2]);

        Object[][] a = {
                {1,"kuai",7,"j","20180819"},
                {2,"kuai",7,"j","20180819"},
                {3,"kuai",7,"j","20180819"},
        };
        System.out.println(a[1][1]);*/

    }

//    数组扩容插入指定内容

    //    删除指定数组中的一个值
    public static String123[] removeElment(String123[] s, int i){
        System.arraycopy(s,i+1,s,i,s.length-i-1);
        s[s.length-1] = null;
        return s;
    }
    //    删除指定数组中的一个值
    public static String123[] removeT(String123[] s, int i, int j){
        int a = j - i;
        if (j+1<s.length) {
            System.arraycopy(s, j + 1, s, i, a + 1);
        }
        for (int p = s.length-a-1; p <= s.length-1; p++){
            s[p] = null;
        }
        return s;
    }
}
