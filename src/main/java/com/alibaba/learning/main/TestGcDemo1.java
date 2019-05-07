package com.alibaba.learning.main;

public class TestGcDemo1 {
    private static  int MB_SIZE=1024*1024;
    public static void main(String[] args) {

        byte[] allocatedBytes1=new byte[2*MB_SIZE];

        byte[] allocatedBytes2=new byte[2*MB_SIZE];

        byte[] allocatedBytes3=new byte[2*MB_SIZE];

        byte[] allocatedBytes4=new byte[4*MB_SIZE];



    }
}
