package com.chen.classloader;

import java.util.ArrayList;
import java.util.List;

/**JDK8中运行时常量池是元数据空间的一部分，以下也是测试不断往运行时常量池添加类元信息，导致MetaSpace溢出
 * 本案例用来测试MetaSpace的溢出，证明类加载后的类元信息是存在于元数据空间，
 * 如果想快点出现结果，需要把MetaSpace设置小一点，同时被测试的类可以多设置一些字段，以及方法，创建大对象属性是没用的，因为对象存在堆中
 * -verbose:gc
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:+PrintGCDetails
 * -XX:MetaspaceSize=20M
 * -XX:MaxMetaspaceSize=20m
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {

        MyClassLoader myClassLoader = new MyClassLoader();
        List<Class> list=new ArrayList<>();
        while (true) {
            Thread.sleep(5);
            //每次都new不同的类加载器来加载，这样及即使加载的是同一个文件，最终得到的也不是同一个class
            Class<?> hello = new MyClassLoader().loadClass("Hello");
            //一定要把加载的Class找个地方让它被使用，不然元数据空间的Class文件在内存不够的时候会被GC，无法出现MetaSpace溢出的现象
            list.add(hello);
        }
    }
}
