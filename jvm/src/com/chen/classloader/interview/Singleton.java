package com.chen.classloader.interview;

/**
 * 面试题，考察类加载的机制
 */
public class Singleton {
    private static Singleton singleTon = new Singleton();

    //构造代码块，在构造方法之前执行，
    {
        System.out.println("Constructor block,count1:" + count1);//0
        System.out.println("Constructor block,count2:" + count2);//0
    }

    public static int count1;
    public static int count2 = 0;

    private Singleton() {
        System.out.println("Constructor init");
        count1++;
        count2++;
    }

    public static Singleton getInstance() {
        return singleTon;
    }
}

class Test {
    public static void main(String[] args) {
        Singleton singleTon = Singleton.getInstance();
        System.out.println("count1=" + singleTon.count1);//1
        System.out.println("count2=" + singleTon.count2);//0
    }
}