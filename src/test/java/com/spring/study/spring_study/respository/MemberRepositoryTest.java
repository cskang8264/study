package com.spring.study.spring_study.respository;

import com.spring.study.spring_study.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void saveMemberTest() {
        long id = 2L;
        String username = "Member B";
        int age = 21;

        Member member = Member.builder()
                .age(age)
                .username(username)
                .build();

        Member saveMember = memberRepository.save(member);
        System.out.println("System.out.println(saveMember);");
        System.out.println(saveMember);

        Assertions.assertEquals(saveMember.getAge(), age);
        Assertions.assertEquals(saveMember.getUsername(), username);


    }
}
