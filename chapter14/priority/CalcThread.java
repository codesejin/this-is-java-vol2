package org.example.chapter14.priority;

public class CalcThread extends Thread {
    public CalcThread(String name) {
        setName(name); // 스레드 이름 설정
    }

    // ThreadA 실행내용
    public void run() {
        for (int i = 0; i < 2000000000; i++) {
        }
        System.out.println(getName());
    }
}
