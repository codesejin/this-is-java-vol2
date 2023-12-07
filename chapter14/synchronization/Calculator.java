package org.example.chapter14.synchronization;

//공유 객체
public class Calculator {
    private int memory;

    public int getMemory() {
        return memory;
    }
    // 계산기 메모리에 값을 저장하는 메모리
    public void setMemory(int memory) {
        synchronized (this) {
            this.memory = memory;// 매개값을 memory필드에 저장
            try {
                Thread.sleep(2000); // 스레드를 2초간 일시정지
            } catch (InterruptedException e) {}
            //스레드 이름                                //메모리 값
            System.out.println(Thread.currentThread().getName() + ": " + this.memory);
        }
    }
}
