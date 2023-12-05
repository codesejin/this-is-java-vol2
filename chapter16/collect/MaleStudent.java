package org.example.chapter16.collect;

import org.example.chapter16.Student;

import java.util.ArrayList;
import java.util.List;

public class MaleStudent {
    private List<Student> list; // dythfmf wjwkdgkf zjffprtus

    public MaleStudent() {
        list = new ArrayList<Student>();
                                // 생성자를 호출하는 스레드 이름
        System.out.println("[" + Thread.currentThread().getName() + "] MaleStudent");
    }

    // 요소를 수집하는 메소드
    public void accumulate(Student student) {
        list.add(student);
        System.out.println("[" + Thread.currentThread().getName() + "] accumulate()");
    }

    // 두 MaleStudent 를 결합하는 메소드(병렬 처리 시에만 호출)
    public void combine(MaleStudent other) {
        list.addAll(other.getList());
        System.out.println("[" + Thread.currentThread().getName() + "] combine()");
    }
    // 요소가 저장된 컬렉션을 리턴
    public List<Student> getList() {
        return list;
    }
}
