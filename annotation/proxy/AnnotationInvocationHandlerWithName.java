package org.example.annotation.proxy;

import org.example.annotation.MyCustomAnnotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface MyInterfaceB { // 인터페이스 생성

    @MyCustomAnnotation(number = 42)
    void myMethod();
}

class InterfaceImplB implements MyInterfaceB { // 구현체 생성
    @Override
    public void myMethod() {
        System.out.println("Real object's method");
    }
}

// InvocationHandler를 구현하지 않고 바로 어노테이션을 구현한 클래스의 인스턴스 반환
class MyAnnotationInvocationHandler implements InvocationHandler {
    private final String value;
    private final int number;

    MyAnnotationInvocationHandler(String value, int number) {
        this.value = value;
        this.number = number;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println(">>> InvocationHandler 시작");
        if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
            System.out.println(">>> MyCustomAnnotation이 메서드에 존재!");
            MyCustomAnnotation methodAnnotation = method.getAnnotation(MyCustomAnnotation.class);

            // 어노테이션의 속성값에 접근
            String newValue = value;
            int newNumber = number;
            // .. 변경할수있는 메소드가 없음
            System.out.println(">>> 변경 전 Annotation value: " + methodAnnotation.value());
            System.out.println(">>> 변경 후 Annotation value: " + newValue);
            System.out.println(">>> 변경 전 Annotation number: " + methodAnnotation.number());
            System.out.println(">>> 변경 후 Annotation number: " + newNumber);
        }
        return null;
    }
}

public class AnnotationInvocationHandlerWithName {
    public static void main(String[] args) {
        // 어노테이션을 구현한 클래스를 직접 생성하지 않고 Proxy를 사용하여 프록시 객체 생성
        MyInterfaceB proxyB = (MyInterfaceB) Proxy.newProxyInstance(
                MyInterfaceB.class.getClassLoader(),
                new Class[]{MyInterfaceB.class},
                new MyAnnotationInvocationHandler("Hello from Proxy", 1000));

        // 프록시 객체의 어노테이션 메서드 호출
        proxyB.myMethod();//
    }
}

