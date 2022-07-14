package com.spring.study.spring_study.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class StreamTest {
    private final List<String> words = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    @Test
    void wordProcessTest() {
        String result = words.stream()
                .filter(w -> w.length() > 1)
                .map(String::toUpperCase)
                .map(w -> w.substring(0, 1))
                .collect(Collectors.joining(" "));

        assertThat(result).isEqualTo("T H A N K");
    }

    @Test
    void solution() {
        StringBuilder result = new StringBuilder();
        String answer = "";
        String bits = "11101010000001010000100100010001";
        for (int i = 0; i < bits.length(); i+=8) {
            System.out.println("i = " + i);
            answer = answer.concat(String.valueOf(Integer.parseInt(bits.substring(i,i+8),2)));
            if (i != 24){
                answer = answer.concat(".");
            }
        }

        System.out.println("answer = " + answer);



    }

    @Test
    void solution2() {
        String start_date = "05/04 MON";  // 05/08 금 + 4
        String end_date = "05/30";
        String[] start_date_split = start_date.split(" ");
        int count = 0;
        int result = 0;
        String[] login_dates = {"05/26","05/25","05/27","05/10","05/11","05/23","05/22","05/21","05/06","05/09","05/07","05/08"};
        List<String> login_date_list = Arrays.asList(login_dates);
        String[] dates = {"MON","TUE","WED","THU","FRI","SAT","SUN"};

        if (start_date_split[1].equals("MON")) {
            count = 0;
        } else if (start_date_split[1].equals("TUE")) {
            count = 1;
        } else if (start_date_split[1].equals("WED")) {
            count = 2;
        } else if (start_date_split[1].equals("THU")) {
            count = 3;
        } else if (start_date_split[1].equals("FRI")) {
            count = 4;
        } else if (start_date_split[1].equals("SAT")) {
            count = 5;
        } else {
            count = 6;
        }

        Collections.sort(login_date_list);
        int parsed_start_date = Integer.parseInt(start_date_split[0].substring(3,5));

        for (int i = 1; i < login_date_list.size(); i++) {
            int nextDay = Integer.parseInt(login_date_list.get(i).substring(3,5));
            int currentDay = Integer.parseInt(login_date_list.get(i-1).substring(3,5));
            int weekEndNumber = Math.abs((parsed_start_date + count) - currentDay) % 7;
            if (nextDay-currentDay > 1) {
                if (weekEndNumber == 5 || weekEndNumber == 6) {

                }
            }
        }
        System.out.println("start = " + Integer.parseInt(start_date_split[0].substring(3,5)));

//        for (String data: login_date_list) {
//

//            System.out.println("data = " + Integer.parseInt(data.substring(3,5)));
//        }



    }

    @Test
    void solution3() {
        int[] scores =  {1,3,7,8,10,15};
        int answer = 0;
        int k = 3;
        List<Integer> diff_list = new ArrayList<>();
        for (int i = 1; i < scores.length; i++) {
            diff_list.add(Integer.valueOf(scores[i]-scores[i-1]));
        }
        Collections.sort(diff_list);

        for (int i = 0; i < scores.length-k; i++) {
            answer += diff_list.get(i);
        }
        System.out.println("answer = " + answer);
    }

    public class MergeNames {

        public static String[] uniqueNames(String[] names1, String[] names2) {

            throw new UnsupportedOperationException("Waiting to be implemented.");
            Set<String> result = new HashSet<>();

            for (String name: names1) {
                result.add(name);
            }

            for (String name: names2) {
                result.add(name);
            }

            return result.toArray(String[]::new);


        }

        public static void main(String[] args) {
            String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
            String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
            System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
        }
    }
}
