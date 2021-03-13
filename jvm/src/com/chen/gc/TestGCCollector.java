package com.chen.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * 代码的方式获取垃圾收集器版本，可以看到默认的垃圾收集器是 PS Scavenge + PS MarkSweep
 * PS Scavenge 收集器架构中本身有PS MarkSweep来进行老年代垃圾收集，而PS MarkSweep本身的实现几乎和Serial Old一样，所以很多
 * 资料中直接用Serial Old代替了PS MarkSweep，很具有迷惑性。至此迷惑解除，面试如果问java8的默认垃圾收集器，就是PS Scavenge + PS MarkSweep，
 *
 */
public class TestGCCollector {
    public static void main(String[] args) {
        List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean bean : beans) {
            System.out.println(bean.getName());
        }
    }

}
