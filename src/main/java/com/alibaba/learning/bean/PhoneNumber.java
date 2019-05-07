package com.alibaba.learning.bean;


import com.alibaba.fastjson.JSON;
import lombok.Data;


public class PhoneNumber  implements  Cloneable{
    private String areaCode;
    private String prefix;
    private String lineNumber;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    @Override
    public PhoneNumber clone()  {
        try {
         return (PhoneNumber) super.clone();
        }catch (CloneNotSupportedException e){

        }
        return null;
    }
}
