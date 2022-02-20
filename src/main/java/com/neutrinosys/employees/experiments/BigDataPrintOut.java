package com.neutrinosys.employees.experiments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigDataPrintOut {
    public static void main(String[] args) throws IOException {
        Files.lines(Path.of("/Users/terrymartin/Documents/Neutrino/Java Course Files/10.12 Streams & Lambdas/Hr5m.csv"))
                .limit(11)
                .forEach(System.out::println);
    }
}
