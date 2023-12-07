package org.example.chapter14.synchronization;

public class User2 extends  Thread {
    private Calculator calculator;

    public void setCalculator(Calculator calculator) {
        this.setName("CalculatorUser2");// 스레드 이름을 CalculatorUser12로 설정
        this.calculator = calculator;// 공유 객체인 Calculator를 필드에 저장
    }

    public void run() {
        calculator.setMemory(50);// 공유 객체인 Calculator의 메모리에 50을 저장
    }
}
