package org.example.reflection.getResource;

import java.net.URL;

public class GetResourceExample {
    public static void main(String[] args) {
        Class clazz = Car.class;

        URL photo1Path = clazz.getResource("photo1.jpg");
        URL photo2Path = clazz.getResource("images/photo2.jpg");

        System.out.println(photo1Path);
        System.out.println(photo2Path);
    }
}
