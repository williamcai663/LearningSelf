package com.alibaba.learning.main;

public class TestEnum {

    public static void main(String[] args) {

        System.out.println(Instance.SINGTION);

        System.out.println(Instance.SINGTION==Instance.SINGTION);
    }

    enum  Instance{
        SINGTION("name");

        String type;

        Instance(String type){
            this.type=type;
        }


    }
}
