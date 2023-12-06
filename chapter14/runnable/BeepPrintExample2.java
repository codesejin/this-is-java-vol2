package org.example.chapter14.runnable;

import org.example.chapter14.subClass.BeepPrintExample3;

import java.awt.*;

// 메인스레드와 작업스레드가 동시에 실행
public class BeepPrintExample2 {
    // 메인스레드
    public static void main(String[] args) {
        BeepPrintExample3.BeepTask beepTask = new BeepPrintExample3.BeepTask();
        Thread thread1 = new Thread(beepTask);
        thread1.start(); // BeepRunnable

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500); // 0.5초간 일시정지
            } catch (Exception e) {}
        }

        // Runnable 익명 객체 사용
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 스레드 실행 내용
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep(); // 비프음 발생
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {}
                }
            }
        });

    }
}
