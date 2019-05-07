package com.alibaba.learning.main;

import com.alibaba.learning.bean.PhoneNumber;

import java.util.HashMap;
import java.util.Map;

public class TestToString {

    public static void main(String[] args) {
        PhoneNumber phoneNumber=new PhoneNumber();
        phoneNumber.setAreaCode("025");
        phoneNumber.setPrefix("-");
        phoneNumber.setLineNumber("12345");
        Map<String,Object> map=new HashMap<>();
        PhoneNumber cloneObj=phoneNumber.clone();
        System.out.println(phoneNumber.toString());

        System.out.println(phoneNumber.getClass()==cloneObj.getClass());

        System.out.println(phoneNumber.equals(cloneObj));
        map.put("cloneString",cloneObj);
        System.out.println(map.toString());
    }
}
