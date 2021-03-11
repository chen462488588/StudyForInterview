package com.chen.gc;

/**
 * 证明hotspot虚拟机不是采用引用计数的方式来回收垃圾，以下代码在垃圾回收日志中可以看到回到了20M以上的空间，说明程序并没有因为它是相互循环
 * 引用就不回收它，排除 引用计数
 */
public class GC1 {
    private Object instance = null;
    public static final int _1M = 1024 * 1024;
    //此对象是用来观察垃圾回收的，专门搞个大对象
    private byte[] bigObject = new byte[10 * _1M];

    public static void main(String[] args) {

        GC1 obj1 = new GC1();
        GC1 obj2 = new GC1();
        obj1.instance = obj2;
        obj2.instance = obj1;

        obj1 = null;
        obj2=null;
        System.gc();

    }
}
