package org.example.annotation.proxy;

import org.example.annotation.MyCustomAnnotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface MyInterfaceA {
    @MyCustomAnnotation(number = 42)
    void myMethod();
}

class MyRealObject implements MyInterfaceA {
    public void myMethod() {
        System.out.println("Real object's method");
    }
}

public class AnnotationProxyInstane {
    public static void main(String[] args) {
        MyInterfaceA realObject = new MyRealObject();

        // 방법 1: newProxyInstance 메서드 사용
        MyInterfaceA proxyObject = (MyInterfaceA) Proxy.newProxyInstance(
                MyInterfaceA.class.getClassLoader(),
                new Class[]{MyInterfaceA.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Before method call");

                        // 메서드에 MyCustomAnnotation이 존재하는지 확인
                        if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
                            System.out.println(">>> MyCustomAnnotation이 메서드에 존재!");
                            MyCustomAnnotation methodAnnotation = method.getAnnotation(MyCustomAnnotation.class);

                            // 어노테이션의 속성값에 접근
                            String value = methodAnnotation.value();
                            int number = methodAnnotation.number();

                            System.out.println(">>> Annotation value: " + value);
                            System.out.println(">>> Annotation number: " + number);

                        }
                        Object result = method.invoke(realObject, args);
                        System.out.println("After method call");
                        return result;
                    }
                });
        proxyObject.myMethod();
    }
}
