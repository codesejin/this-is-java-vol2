package org.example.chapter14.name;

public class ThreadB extends Thread{
    // ThreadB 실행내용
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println(getName() + "가 출력한 내용");
        }
    }
}
