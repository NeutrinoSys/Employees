package com.neutrinosys.employees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamsStuff {
    public static void main(String[] args) {
//        String peopleText = """
//            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2500,yoe=10,iq=140}
//            Flinstone, Fred, 1/1/1900, Programmer, {locpd=4000,yoe=10,iq=140}
//            Flinstone, Fred, 1/1/1900, Programmer, {locpd=5000,yoe=10,iq=140}
//            Flinstone, Fred, 1/1/1900, Programmer, {locpd=6000,yoe=10,iq=140}
//            Flinstone, Fred, 1/1/1900, Programmer, {locpd=7000,yoe=10,iq=140}
//            Flinstone, Fred, 1/1/1900, Programmer, {locpd=9000,yoe=10,iq=140}
//            Flinstone, Fred, 1/1/1900, Programmerzzzzz, {locpd=10000,yoe=10,iq=140}
//            Flinstone2, Fred2, 1/1/1900, Programmer, {locpd=1300,yoe=14,iq=100}
//            Flinstone3, Fred3, 1/1/1900, Programmer, {locpd=2300,yoe=8,iq=105}
//            Flinstone4, Fred4, 1/1/1900, Programmer, {locpd=1630,yoe=3,iq=115}
//            Flinstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=100}
//            Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
//            Rubble2, Barney2, 2/2/1905, Manager, {orgSize=100,dr=4}
//            Rubble3, Barney3, 2/2/1905, Manager, {orgSize=200,dr=2}
//            Rubble4, Barney4, 2/2/1905, Manager, {orgSize=500,dr=8}
//            Rubble5, Barney5, 2/2/1905, Manager, {orgSize=175,dr=20}
//            Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
//            Flinstone2, Wilma2, 3/3/1910, Analyst, {projectCount=4}
//            Flinstone3, Wilma3, 3/3/1910, Analyst, {projectCount=5}
//            Flinstone4, Wilma4, 3/3/1910, Analyst, {projectCount=6}
//            Flinstone5, Wilma5, 3/3/1910, Analyst, {projectCount=9}
//            Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
//            """;

        try {
            Map<String, List<Employee>> empsBySurname = Files.lines(Path.of("/Users/terrymartin/IdeaProjects/Employees/src/main/java/com/neutrinosys/employees/employees.txt"))
                    .map(Employee::createEmployee)
                    .map(e -> (Employee) e)
                    .collect(groupingBy(Employee::getLastName));
//            empsBySurname.forEach((k,v) -> System.out.printf("%s = $%,.2f%n",k,Float.valueOf(v)));
            System.out.println(empsBySurname);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String[] names = {"terry", "sam", "jake"};
        Arrays.stream(names)
                .map(String::toUpperCase)
                .forEach(System.out::println);


        // 1-2-3-4-5-




















//        Predicate<Employee> dummyEmpSelector = employee -> "N/A".equals(employee.getLastName());
//        Predicate<Employee> overFiveKSelector = e -> e.getSalary() > 5000;
//        Predicate<Employee> noDummiesAndOverFiveK = dummyEmpSelector.negate().and(overFiveKSelector);
//        OptionalInt result = peopleText
//                .lines()
//                .map(Employee::createEmployee)
//                .map(e -> (Employee)e)
//                .filter(noDummiesAndOverFiveK)
//                .collect(Collectors.toSet()).stream()
//                .sorted(comparing(Employee::getLastName) // (x,y) -> x.getLastName().compareTo(y.getLastName())
//                    .thenComparing(Employee::getFirstName)
//                    .thenComparingInt(Employee::getSalary))
//                .skip(5)
//                .mapToInt(StreamsStuff::showEmpAndGetSalary)
//                .reduce(Integer::max);
//        IntStream.rangeClosed(0,10)
//                .mapToObj(String::valueOf)
//                .collect(Collectors.joining("-")).lines()
//                .forEach(System.out::println);
//
//        System.out.println(result.orElse(0));

    }

    public static int showEmpAndGetSalary(IEmployee e) {
        System.out.println(e);
        return e.getSalary();
    }
}
