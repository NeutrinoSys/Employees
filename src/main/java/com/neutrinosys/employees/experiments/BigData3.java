package com.neutrinosys.employees.experiments;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.summingLong;

public class BigData3 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("/Users/terrymartin/Documents/Neutrino/Java Course Files/10.12 Streams & Lambdas/Hr5m.csv");
            BufferedReader br = new BufferedReader(fr);
//            br.rea
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
