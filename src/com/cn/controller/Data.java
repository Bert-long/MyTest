package com.cn.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Data {
    public  static void main(String[] args) throws ParseException {
//        long nowTime = System.currentTimeMillis();
        Date d = new Date();
        System.out.println(d);
        Date d1 = new Date(2000);
        System.out.println(d1.getTime());
//      把时间对象转换成相应的字符串
        DateFormat a = new SimpleDateFormat("yyyy年MM月DD日 hh:mm:ss");
        String str = a.format(new Date(400000));
        System.out.println(str);
//      把字符串转换成相应的时间对象
        DateFormat a1 = new SimpleDateFormat("yyyy年MM月DD日 hh时mm分ss秒");
        Date date = null;
        try {
            date = a1.parse("2010年04月01日 12时12分12秒");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
//      获取日期相关元素
        Calendar calendar = new GregorianCalendar(2999,10,9,22,10,50);
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH);

        System.out.println("获取的年" + y + "获取的月" + m);
//      设置日期相关元素
        Calendar calendar1 = new GregorianCalendar();
        calendar1.set(Calendar.YEAR, 2222);
//      日期对象和时间对象的转化
//        Date d = calendar1.getTime();
        Calendar calendar2 = new GregorianCalendar();
        calendar2.setTime(new Date());
//      打印日历
        String s = "2020-09-01";
        DateFormat da = new SimpleDateFormat("yyyy年mm月dd日");
        try {
            Date date1 = da.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = new GregorianCalendar();
//        c.setTime(date1);

        System.out.println("日\t一\t二\t三\t四\t五\t六");
        for (int i=0; i<=31; i++){
            System.out.println(i+"\t");
        }

    }
}
