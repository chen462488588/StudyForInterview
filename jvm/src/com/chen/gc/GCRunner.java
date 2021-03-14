package com.chen.gc;


import java.util.ArrayList;
import java.util.List;

/**
 * 不停的gc，本次实验不停地new String("xxx");但是不引用它
 * 现象：Eden区满了以后，会触发Minor GC，同时给对象计算一次年龄，程序继续执行，当Edel又不够的时候会再次触发Minor GC，此时年龄大于1 的存活对象会进入老年代，
 * 如此一直循环下去，当老年代也被填充满了以后，会触发 一次Major GC（也叫Full gc），这个程序是能够一直死循环下去，因为虽然一直new对象，但是一直没有用它，一直能回收
 * -Xmx5m
 * -Xms5m
 * -Xmn3m
 * -XX:+PrintGCDetails
 * -XX:MaxTenuringThreshold=1 对象年龄一岁的时候久进入老年代，设置1是为了快速看到对象进入老年代的现象
 */
public class GCRunner {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        while (true) {
            new String("xxx");
        }
    }
}

/**
 * 不停的gc，本次实验不停地String.valueOf(i++).intern();但是不引用它
 * 现象：开始会触发Eden的Minor GC 当最终会Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 * 原因intern()会
 * -Xmx2m
 * -Xms2m
 * -Xmn1m
 * -XX:+PrintGCDetails
 * -XX:MaxTenuringThreshold=1 对象年龄一岁的时候久进入老年代，设置1是为了快速看到对象进入老年代的现象
 */
/*
public class GCRunner {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        long i =0;
        while (true) {
//            Thread.sleep(1);
            String.valueOf(i++).intern();
//            String a = (i+++"").intern();
        }
    }
}*/
