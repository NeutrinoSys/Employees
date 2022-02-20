package com.neutrinosys.employees;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static java.util.stream.Collectors.*;

public class BigData {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

    record Person(String firstName, String lastName, BigDecimal salary, String state, char gender, LocalDate birthDate, LocalTime birthTime) {
        long getAge() {
            return Period.between(birthDate, LocalDate.now()).getYears();
        }

        String getDOBAsText() {
            return dateFormatter.format(birthDate);
        }

        LocalDateTime getCompleteDOB() {
            return LocalDateTime.of(birthDate, birthTime);
        }
    }
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
//            long count =
                    Files.lines(Path.of("/Users/terry/Documents/Neutrino/Java Course Files/10.12 Streams & Lambdas/Hr5m.csv")).parallel()
                    .skip(1)
                    .limit(20)
                    .map(s -> s.split(","))
                    .map(a -> new Person(a[2], a[4], new BigDecimal(a[25]), a[32], a[5].strip().charAt(0),
                            LocalDate.parse(a[10], dateFormatter),
                            LocalTime.parse(a[11], timeFormatter)))
                    .filter(p -> p.getAge() < 30)
//                    .count();
                    .forEach(p -> System.out.printf("%s, %s %s - %d%n", p.lastName(), p.firstName(), p.getDOBAsText(), p.getAge()));

            long endTime = System.currentTimeMillis();
//            System.out.printf("$%,d.00%n", result);
//            System.out.println(result);
//            System.out.println(count);
            System.out.println(endTime - startTime);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
