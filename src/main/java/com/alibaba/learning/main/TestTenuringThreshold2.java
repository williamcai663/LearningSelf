package com.alibaba.learning.main;

public class TestTenuringThreshold2 {
    private static  int MB_SIZE=1024*1024;
    public static void main(String[] args) {
        byte[] allocate1,allocate2,allocate3,allocate4;

        allocate1=new byte[MB_SIZE/4];
        allocate2=new byte[MB_SIZE/4];
        allocate3=new byte[4*MB_SIZE];
        allocate4=new byte[4*MB_SIZE];
        allocate4=null;
        allocate4=new byte[4*MB_SIZE];

    }
}
