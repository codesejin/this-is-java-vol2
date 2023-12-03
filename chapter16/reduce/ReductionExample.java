package org.example.chapter16.reduce;

import org.example.chapter16.Student;

import java.util.Arrays;
import java.util.List;

public class ReductionExample {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동",92),
                new Student("신용권",95),
                new Student("감자바",88)
        );
        //sum()이용
        int sum1 = studentList.stream()
                .mapToInt(Student :: getScore)
                .sum();

        //reduce(IntBinaryOperator op이용)
        int sum2 = studentList.stream()
                .map(Student :: getScore)
                .reduce((a, b) -> a + b)
                .get();

        //reduce(int identity, IntBinaryOperator op이용)
        int sum3 = studentList.stream()
                .map(Student :: getScore)
                .reduce(0, (a, b) -> a + b);

        System.out.println("sum1: " + sum1);
        System.out.println("sum2: " + sum2);
        System.out.println("sum3: " + sum3);
    }
}
