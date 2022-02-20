package com.neutrinosys.employees;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateCounter {
    public static void main(String[] args) throws IOException {
        Map<String, Long> stateCounts = new HashMap<>();
        Files.lines(Path.of("/Users/terrymartin/Documents/Neutrino/Java Course Files/10.12 Streams & Lambdas/Hr5m.csv"))
                .skip(1)
                .map(l -> l.split(","))
                .forEach(a -> stateCounts.merge(a[32], 1L, (x,y) -> x + y));
        System.out.println(stateCounts);

        List.of("cat", "dog").toArray();


//        Long curPopulation = stateCounts.get("CA");
//        if (curPopulation == null) {
//            stateCounts.put("CA", 1L);
//        } else {
//            stateCounts.put("CA", ++curPopulation);
//        }
    }

}
