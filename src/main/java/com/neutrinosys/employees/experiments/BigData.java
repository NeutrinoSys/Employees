package com.neutrinosys.employees.experiments;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class BigData {

    record Person(String firstName, String lastName, BigDecimal salary, String state, char gender, LocalDate dob) {
        Period age() {
            return Period.between(dob, LocalDate.now());
        }
    }
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
//            Map<String, String> result =
            //Map<String(state), Map<char(gender), String(formatted-salary)>>
//            Map<String, Long> result =
                    Files.lines(Path.of("/Users/terry/Documents/Neutrino/Java Course Files/10.12 Streams & Lambdas/Hr5m.csv")).parallel()
                    .skip(1)
//                    .limit(100)
                    .map(s -> s.split(","))
                    .map(a -> new Person(a[2], a[4], new BigDecimal(a[25]), a[32], a[5].strip().charAt(0), LocalDate.parse(a[10].strip(), DateTimeFormatter.ofPattern("M/d/yyyy"))))
                            .filter(p -> p.age().getYears() < 23)
                    .forEach(p -> System.out.printf("%s, %s - %s - %d years, %d months, %d days%n", p.lastName(), p.firstName(), p.dob().toString(), p.age().getYears(), p.age().getMonths(), p.age().getDays()));
//                    .forEach((state, salary) -> System.out.printf("%s -> %s%n", state, salary));
//                    .collect(groupingBy(Person::state, counting()));
            long endTime = System.currentTimeMillis();
//            System.out.printf("$%,d.00%n", result);
//            System.out.println(result);
            System.out.println(endTime - startTime);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
