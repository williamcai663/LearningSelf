package com.alibaba.learning.endpoint;

import com.alibaba.learning.bean.User;

public class TestBuilder {

    public static void main(String[] args) {
        User user = new User.Builder(10L).name("jackcai").className("No1").gender("man").build();

    }
}
