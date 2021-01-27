package com.cn;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.util.ArrayList;

public class Time {
    private static ArrayList<String> filelist=new ArrayList<>();
    private static long totalTime;
    public static void main(String[] args) {

        String path1="D:\\BaiduNetdiskDownload\\01. JAVA初级阶段【北京尚学堂·百战程序员】\\01. java300集【北京尚学堂·百战程序员】\\";//放入需要统计文件夹绝对路径
        String path2 = path1.concat("11_手写服务器httpserver项目(java基础集大成者)");
        String path3 = path1.concat("12_注解_反射_字节码_类加载机制"); //400
        String path4 = path1.concat("13_GOF23设计模式全解");          //600
        String path5 = path1.concat("14_正则表达式和文本操作");        //100
        String path6 = path1.concat("15_JDBC数据库操作");             //200
        String path7 = path1.concat("16_手写SORM框架(学有余力同学观看)"); //360
        String path8 = path1.concat("17_预科阶段(针对零基础和行业介绍，可跳过)"); //224

        getFile(path8);
        System.out.println("文件夹中视屏总时长为"+Int2String(totalTime)+"min");
    }
    public static void getFile(String path) {

        File root=new File(path);
        File[] files=root.listFiles();
        for(File file:files) {

            if(file.isDirectory()) {

                getFile(file.getAbsolutePath());
                filelist.add(file.getAbsolutePath());
                System.out.println(path+"下的目录"+file.getAbsolutePath());
            }else {

                String fileName=file.getName().trim();
                String type=fileName.substring(fileName.lastIndexOf("."));
                if(type.equals(".mp4")) {

                    System.out.print(fileName+"是视屏文件，文件的大小为"+file.length()+"   ");
                    MultimediaInfo m = null;
                    Encoder encoder = new Encoder();
                    try {

                        m = encoder.getInfo(file);
                    } catch (InputFormatException e) {

                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (EncoderException e) {

                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    long ls = m.getDuration();
                    String vtime=Int2String(ls);
                    System.out.println(vtime);
                    totalTime+=ls;
                }else {

                    System.out.println(fileName+"不是视屏文件");
                }
            }
        }
    }
    //将文件时长单位转换为min
    public static String Int2String(long ls) {

        String vtime;
        if ((ls / 60000) < 10) {

            vtime = "0" + ls / 60000 + "." + ((ls / 1000) - ((ls / 60000) * 60));

        } else if ((ls / 60000) < 10 && ((ls / 1000) - ((ls / 60000) * 60)) < 10) {

            vtime = "0" + ls / 60000 + "." + "0" + ((ls / 1000) - ((ls / 60000) * 60));

        } else if ((ls / 60000) > 9 && ((ls / 1000) - ((ls / 60000) * 60)) < 10) {

            vtime = ls / 60000 + "." + "0" + ((ls / 1000) - ((ls / 60000) * 60));

        } else {

            vtime = +ls / 60000 + "." + ((ls / 1000) - ((ls / 60000) * 60));
        }
        return vtime;
    }
}
