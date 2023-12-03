package org.example.chapter16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromDirectoryExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/org/example");
        Stream<Path> stream = Files.list(path);
        // p:서브 디렉토리 또는 파일에 해당하는 Path객체
        stream.forEach(p -> System.out.println(p.getFileName()));
    }
}
