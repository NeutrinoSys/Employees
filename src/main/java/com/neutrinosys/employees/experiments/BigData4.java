package com.neutrinosys.employees.experiments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BigData4 {
    public static void main(String[] args) throws IOException {
        String peeps = """
                742048,Drs.,Lizeth,P,Mccoll,F,lizeth.mccoll@ibm.com,Renato Mccoll,Serena Mccoll,Broxton,7/5/1973,08:14:43 AM,47.19,49,1/7/1995,Q1,H1,1995,1,January,Jan,7,Saturday,Sat,25.67,147446,14%,171-86-6830,216-703-2865,Alliance,Stark,Alliance,OH,44601,Midwest,lpmccoll,b5CDsd1Mz.
                671135,Ms.,Argentina,O,Hern,F,argentina.hern@ntlworld.com,Earl Hern,Chrissy Hern,Tapley,10/15/1962,02:08:22 AM,57.92,53,4/1/1986,Q2,H1,1986,4,April,Apr,1,Tuesday,Tue,34.44,129174,8%,083-02-3078,202-572-0136,Washington,District of Columbia,Washington,DC,20411,South,aohern,vsUv&nFc?lM|2-
                965851,Mr.,Damian,N,Patillo,M,damian.patillo@outlook.com,Harley Patillo,Lucinda Patillo,Etter,3/11/1975,07:48:45 PM,45.51,84,12/16/2004,Q4,H2,2004,12,December,Dec,16,Thursday,Thu,15.72,158746,8%,326-11-9852,209-784-3915,Burrel,Fresno,Burrel,CA,93607,West,dnpatillo,GQj^c:4#B:F8
                224660,Drs.,Imogene,P,Hagopian,F,imogene.hagopian@gmail.com,Delmar Hagopian,Carolina Hagopian,Lockett,2/19/1995,03:15:09 PM,25.55,52,6/8/2017,Q2,H1,2017,6,June,Jun,8,Thursday,Thu,3.23,55761,14%,656-36-0772,210-460-6327,Bryan,Brazos,Bryan,TX,77806,South,iphagopian,d[aHK7aiH&
                852694,Mr.,Walker,E,Wallach,M,walker.wallach@aol.com,Gale Wallach,Georgianna Wallach,Creekmore,8/5/1992,01:03:46 PM,28.09,50,2/28/2020,Q1,H1,2020,2,February,Feb,28,Friday,Fri,0.51,197519,24%,296-15-3535,225-846-1969,Newllano,Vernon,Newllano,LA,71461,South,wewallach,kM\\7h*}7
                144102,Ms.,Jesusita,W,Hollie,F,jesusita.hollie@hotmail.com,Clement Hollie,Nilda Hollie,Barone,10/30/1987,04:55:43 AM,32.86,49,3/5/2015,Q1,H1,2015,3,March,Mar,5,Thursday,Thu,5.5,103839,6%,375-37-3861,209-219-5562,Topanga,Los Angeles,Topanga,CA,90290,West,jwhollie,p1-G0\\b~
                687793,Mr.,Fausto,P,Esqueda,M,fausto.esqueda@aol.com,Randal Esqueda,Yang Esqueda,Cullens,4/23/1971,10:25:52 AM,49.39,75,10/29/1998,Q4,H2,1998,10,October,Oct,29,Thursday,Thu,21.85,60101,5%,095-02-0857,216-722-2112,Somerdale,Tuscarawas,Somerdale,OH,44678,Midwest,fpesqueda,lX!iJCJF@[f-/F
                636308,Mrs.,Vanda,S,Komar,F,vanda.komar@aol.com,Carlo Komar,Katia Komar,Almanzar,9/2/1962,02:52:40 AM,58.04,52,7/25/2018,Q3,H2,2018,7,July,Jul,25,Wednesday,Wed,2.1,115639,26%,002-11-5408,216-224-9563,Akron,Summit,Akron,OH,44312,Midwest,vskomar,I0!gVO~XFHG0\\9q
                218660,Mrs.,Destiny,A,Nicholson,F,destiny.nicholson@gmail.com,Ramon Nicholson,Tanika Nicholson,Schauer,7/1/1995,01:58:42 PM,25.19,54,11/22/2016,Q4,H2,2016,11,November,Nov,22,Tuesday,Tue,3.78,126048,19%,386-37-5628,201-997-3957,Atlantic City,Atlantic,Atlantic City,NJ,8401,Northeast,danicholson,s|?t/%X+
                """;

//        Files.lines(Path.of("/Users/terrymartin/Documents/Neutrino/Java Course Files/10.12 Streams & Lambdas/Hr5m.csv"))
//                .limit(10)
//                .forEach(System.out::println);


        String fullText = Files.readString(Path.of("/Users/terrymartin/Documents/Neutrino/Java Course Files/10.12 Streams & Lambdas/Hr5m.csv"));
        Pattern salaryPat = Pattern.compile("((.*?,){25})(?<salary>\\d+)?.*", Pattern.MULTILINE);
        Matcher matcher = salaryPat.matcher(fullText);
        Long sum =
        matcher.results()
                .limit(10)
                .mapToLong(r -> Long.parseLong(r.group(3)))
                .sum();
        System.out.println(sum);
    }
}
