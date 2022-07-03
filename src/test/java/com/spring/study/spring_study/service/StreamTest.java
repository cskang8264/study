package com.spring.study.spring_study.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
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
}
