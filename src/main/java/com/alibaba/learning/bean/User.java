package com.alibaba.learning.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@ApiModel("学生")
@Data
public class User {

    @ApiModelProperty(hidden = true)
    private Long id;
    private String name;
    private String className;
    private String gender;


    public static class Builder{
        private Long id;
        private String name;
        private String className;
        private String gender;

        public  Builder(Long id){
            this.id=id;
        }
        public Builder className(String className) {
            this.className = className;
            return  this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }

        public User build(){
            return new  User(this);
        }
    }

    @NotNull
    private User(Builder build){
        id=build.id;
        name=build.name;
        className=build.className;
        gender=build.gender;
    }

}
