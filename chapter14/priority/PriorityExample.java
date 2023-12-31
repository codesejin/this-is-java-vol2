package org.example.chapter14.priority;

public class PriorityExample {
    public static void main(String[] args) {
        for (int i = 0; i <= 10 ; i++) {
            Thread thread = new CalcThread("thread" + i);
            if (i != 10) {
                thread.setPriority(Thread.MIN_PRIORITY);
            } else {
                thread.setPriority(Thread.MAX_PRIORITY);
            }
            thread.start(); // 10이 가장 먼저 실행되어야함
        }
    }
}
