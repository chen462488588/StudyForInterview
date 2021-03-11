package com.chen.stackoverflow;

/**
 * 测试栈溢出StackOverFlow，不停调用自身方法，直到请求深度超过允许最大深度，为了尽快sof可以给方法定义很多参数，这样参数占用很多表空间，会早点触发溢出，因为增加参数会增加栈帧
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -verbose:gc
 * -XX:+HeapDumpOnOutOfMemoryError
 * -Xss10m
 * -XX:+PrintGCDetails
 */
public class StackOverFlowTest {
    public static void main(String[] args) {
        StackOverFlowTest.testStackOverFlow(3,3,"");
    }

    public static void testStackOverFlow(int a,int b,String c){
        testStackOverFlow(3,2,"");
    }
}
