package com.cn.controller;

import java.util.Arrays;

public class 排序 {
    public static void main(String[] args){

       /* // 冒泡排序
        int[] a = {4, 2, 3, 1, 5, 7, 8};
        int b = 0;
        for (int i=0; i<a.length-1; i++){
            if (a[i] > a[i+1]){
                b = a[i];
                a[i] = a[i + 1];
                a[i + 1] = b;
            }
            System.out.println(Arrays.toString(a));
        }*/

        int[] a = {4, 2, 3, 1, 5, 7, 8};
        Arrays.sort(a);
        System.out.println(search(a, 9));
    }

    public static int search(int[] s,int i){

        int l = 0;
        int h = s.length - 1;

        while (l <= h){
            int m = (l + h) / 2;
            if (i == s[m]){
                return i;
            }
            if (i < s[m]){
                h = m - 1;
            }
            if (i > s[m]){
                l = m + 1;
            }
        }

        return -1;
    }
}
