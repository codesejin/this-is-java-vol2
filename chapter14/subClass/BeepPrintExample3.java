package org.example.chapter14.subClass;

import java.awt.*;

// 메인스레드와 작업스레드가 동시에 실행
public class BeepPrintExample3 {
    // 메인스레드
    public static void main(String[] args) {
        BeepTask beepTask = new BeepTask();
        Thread thread1 = new Thread(beepTask);
        thread1.start(); // BeepThread

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500); // 0.5초간 일시정지
            } catch (Exception e) {
            }
        }
    }

    // 비프음을 들려주는 작업정의
    public static class BeepTask implements Runnable{
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
    }
}
