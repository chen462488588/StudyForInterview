package com.chen.oom;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试OOM,并且证明字符串常量池位于堆中，因为OOM时抛出异常Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 *-Xms6m -Xmx6m -verbose:gc -XX:+PrintGCDetails
 */
public class OOMTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
