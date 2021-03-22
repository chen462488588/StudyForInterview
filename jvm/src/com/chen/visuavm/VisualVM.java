package com.chen.visuavm;

import java.util.ArrayList;
import java.util.List;

public class VisualVM {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        int i=0;
        while (true) {
            Thread.sleep(1);
            new String(String.valueOf(i++));
        }
    }
}
