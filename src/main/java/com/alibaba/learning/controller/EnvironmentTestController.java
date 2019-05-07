package com.alibaba.learning.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableScheduling
@EnableAsync
public class EnvironmentTestController {

    @Autowired
    private Environment environment;
    @GetMapping("/mail/conf")
    @ResponseBody
    public JSONObject getMailConfiguration() throws  Exception{
        JSONObject jsonObj=new JSONObject();
        jsonObj.put("server.port",environment.getProperty("mail.host"));
        jsonObj.put("mailuser.name",environment.getProperty("mailuser.name"));
      return jsonObj;
    }

   private int Count=0;

    public void setCount(int count) {
        Count = count;
    }

    public int getCount() {
        return Count;
    }

    //@Scheduled(cron = "*/5 * * * * ?") 单位为毫秒数
    @Scheduled(fixedRate = 5000)
    @Async
    public  void printCount(){
        System.out.println(Thread.currentThread().getName());
        //System.out.println("Count:"+Count);
    }

    @Scheduled(fixedRate = 10000)
    @Async
    public  void printCount1(){
        System.out.println(Thread.currentThread().getName());
    }

    @GetMapping("/testboolean")
    private void testHashMap(){
       Boolean num1= Boolean.valueOf(true);
       Boolean num2=Boolean.valueOf("true");
       if(num1==num2){
           System.out.println("yes");
       }

        System.out.println(Integer.MAX_VALUE);

    }


}
