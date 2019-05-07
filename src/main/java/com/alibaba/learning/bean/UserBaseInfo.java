package com.alibaba.learning.bean;

public class UserBaseInfo {

    private String name;
    private String no;

    private float height;

    private float weight;

    public  class  Builder{

        private String name;

        private String no;
        private float height;
        private float weight;

        public  Builder(String name,String no){
            this.name=name;
            this.no=no;
        }

        public  Builder height(float height){
            this.height=height;
            return this;
        }

        public  Builder weight(float weight){
            this.weight=weight;
            return this;
        }

        public UserBaseInfo build(){
            return copy(this);
        }

    }
    private UserBaseInfo (){

    }
    private UserBaseInfo copy(Builder builder){
       UserBaseInfo userBaseInfo=new UserBaseInfo();
       userBaseInfo.name=builder.name;
       userBaseInfo.no=builder.no;
       userBaseInfo.weight=builder.weight;
       userBaseInfo.height=builder.height;
       return userBaseInfo;
    }
}
