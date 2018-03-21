package com.springboot.main.test;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * Created by Channing on 2018/2/26.
 */
public class Test {
    @org.junit.Test
    public void test01(){
        List<Integer> list = Arrays.asList(51, 32, 3, 64, 95, 26, 2);
        list.stream().sorted().forEach(System.out::println);
    }
}
