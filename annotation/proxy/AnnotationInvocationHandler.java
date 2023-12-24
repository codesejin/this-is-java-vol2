package org.example.annotation.proxy;

import org.example.annotation.MyCustomAnnotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface MyInterface { // 인터페이스 생성
    @MyCustomAnnotation(number = 42)
    void myMethod();
}

class MyInterfaceImpl implements MyInterface { // 구현체 생성
    @Override
    public void myMethod() {
        System.out.println("Real object's method");
    }
}

class MyInvocationHandler implements InvocationHandler { // JDK 동적 프록시
    private final Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("MyInvocationHandler 실행");
        long startTime = System.currentTimeMillis();
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
        long endTime = System.currentTimeMillis();
        long resultTime = endTime-startTime;
        System.out.println("MyInvocationHandler 종료 resultTime= "+ resultTime);
        // 리플랙션을 사용해서 target 인스턴스 메서드(실제 메서드) 실행
        Object result = method.invoke(target, args);
        return result;
    }
}

//class NewProxyInstanceExample {
//    public static void main(String[] args) {
//        MyInterface realObject = new MyInterfaceImpl();
//
//        MyInterface proxyObject = (MyInterface) Proxy.newProxyInstance(
//                MyInterface.class.getClassLoader(),
//                new Class[]{MyInterface.class},
//                (proxy, method, methodArgs) -> {
//                    System.out.println("Before invoking method");
//                    Object result = method.invoke(realObject, methodArgs);
//                    System.out.println("After invoking method");
//                    return result;
//                });
//
//        // 여기에서 myMethod가 호출되면서 Before와 After가 출력됨
//        proxyObject.myMethod();
//    }
//}

public class AnnotationInvocationHandler {
    public static void main(String[] args) {
        MyInterface realObject = new MyInterfaceImpl();

        MyInvocationHandler handler = new MyInvocationHandler(realObject);

        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class},
                handler);
        // 여기에서 myMethod가 호출되면서 어노테이션의 속성값에 접근
        proxy.myMethod();
    }
}
