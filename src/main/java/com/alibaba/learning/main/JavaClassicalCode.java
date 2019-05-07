package com.alibaba.learning.main;

import io.swagger.models.auth.In;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class JavaClassicalCode {

    public static void main(String[] args) throws  Exception{
        Class class1=JavaClassicalCode.class;
        Method[] methods =class1.getDeclaredMethods();
        for (Method method :methods){
            //System.out.println(method.getName());
            if(!"main".equals(method.getName())){
                method.invoke(class1.newInstance());
            }
        }
    }

    public void StringIntegerConvert(){
        String s=String.valueOf(2);
        System.out.println(s);
    }

    public void  getCurrentMethodName(){
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public  void  ConventDate(){
        SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");


        System.out.println(df.format(new Date()));
    }

    public void loadProperties() {
       try {
           Properties properties=new Properties();
           properties.load(new FileInputStream("test.properties"));
           System.out.println(properties.getProperty("db.user"));
       }catch (FileNotFoundException e){

       }catch (IOException e){
           
       }
    }


}
