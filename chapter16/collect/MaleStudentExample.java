package org.example.chapter16.collect;

import org.example.chapter16.Student;

import java.util.Arrays;
import java.util.List;

public class MaleStudentExample {
    public static void main(String[] args) {
        List<Student> totalList = Arrays.asList(
                new Student("홍길동", 10, Student.Sex.MALE),
                new Student("김수애", 6, Student.Sex.FEMALE),
                new Student("신용권", 10, Student.Sex.MALE),
                new Student("박수미", 6, Student.Sex.FEMALE)
                );
        //단일스레드
        MaleStudent maleStudent1 = totalList.stream()
                .filter(s -> s.getSex() == Student.Sex.MALE)
                .collect(MaleStudent::new, MaleStudent::accumulate, MaleStudent::combine);

        maleStudent1.getList().stream()
                .forEach(s -> System.out.println(s.getName()));
        System.out.println();

        //멀티스레드
        MaleStudent maleStudent2 = totalList.parallelStream()
                .filter(s -> s.getSex() == Student.Sex.MALE)
                .collect(MaleStudent::new, MaleStudent::accumulate, MaleStudent::combine);

        maleStudent2.getList().stream()
                .forEach(s -> System.out.println(s.getName()));
    }
}
