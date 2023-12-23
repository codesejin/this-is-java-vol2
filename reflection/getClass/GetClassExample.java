package org.example.reflection.getClass;

public class GetClassExample {
    public static void main(String[] args) {
        // 방법1
        Class clazz = Car.class;

        // 방법2
//        Class clazz = Class.forName("com.example.reflection.getClass.Car");

        // 방법 3
//        Car car = new Car();
//        Class clazz = car.getClass();

        System.out.println("패키지: " + clazz.getPackage());
        System.out.println("패키지 이름: " + clazz.getPackage().getName());
        System.out.println("클래스 간단 이름: " + clazz.getSimpleName());
        System.out.println("클래스 전체 이름: " + clazz.getName());
    }
}
