package com.spring.study.spring_study.codingTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class level_1 {

    @Test
    public void 카카오_계정_생성() {
        String param = "...!@BaT#*..y.abcdefghijklm";

        String id = param.toLowerCase();
        id = id.replaceAll("[^-_.a-z0-9]", ""); //-_. 영문자 숫자만 남김
        id = id.replaceAll("[.]{2,}", "."); // .2개 이상 .으로
        id = id.replaceAll("^[.]|[.]$", ""); // 처음과 끝 . 제거

        if(id.equals("")) // 빈 문자열이라면 a 추가
            id += "a";

        if(id.length() >= 16){ // 16자 이상이면 15자로
            id = id.substring(0, 15);
            id = id.replaceAll("^[.]|[.]$", ""); // 끝 . 제거
        }
        if(id.length() <= 2) // 2자 이하라면 3자까지 마지막 문자추가
            while(id.length() < 3)
                id += id.charAt(id.length() - 1);

        System.out.println("true = " + param.toLowerCase());

        //return id;
    }
}
