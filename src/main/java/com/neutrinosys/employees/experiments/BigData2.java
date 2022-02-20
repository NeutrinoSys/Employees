package com.neutrinosys.employees.experiments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.summingLong;

public class BigData2 {
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            Pattern salaryPat = Pattern.compile("((.*?,){25})(?<salary>\\d+)?.*");
            System.out.printf("%,d%n", Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            Long result =
                    Files.lines(Path.of("/Users/terrymartin/Documents/Neutrino/Java Course Files/10.12 Streams & Lambdas/Hr5m.csv"))
                    .parallel()
                    .skip(1)
                    .map(l -> salaryPat.matcher(l))
                    .filter(Matcher::matches)
//                    .map(m -> m.group("salary"))
//                    .forEach(System.out::println);
                    .collect(summingLong(m -> Long.parseLong(m.group("salary"))));
            long endTime = System.currentTimeMillis();
            System.out.printf("$%,d.00%n", result);
            System.out.println(endTime - startTime);
            System.out.printf("%,d%n", Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
