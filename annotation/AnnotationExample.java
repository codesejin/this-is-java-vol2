package org.example.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {

    @MyCustomAnnotation(number = 42)
    public void annotatedMethod() {
        // 어노테이션이 적용된 메서드
    }

    public static void main(String[] args) throws NoSuchMethodException {
        AnnotationExample example = new AnnotationExample();
        Method[] methods = example.getClass().getMethods();
        for (Method method : methods) {
            // 해당 메서드에 MyCustomAnnotation이 적용되었는지 확인
            if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
                MyCustomAnnotation annotation = method.getAnnotation(MyCustomAnnotation.class);
                int number = annotation.number();
                System.out.println("Method: " + method.getName() + ", Number: " + number);
                String value = annotation.value();
                System.out.println("Method: " + method.getName() + ", Value: " + value);
                System.out.println("------");
            }
            //Object 클래스에서 상속받은 메서드
            System.out.println("Method: " + method.getName() + ", Value: " + method.getDefaultValue());
        }
    }
}
