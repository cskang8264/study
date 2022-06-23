package com.spring.study.spring_study.service;

import com.spring.study.spring_study.domain.Member;
import com.spring.study.spring_study.respository.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
// command + shift + t 테스트 코드 껍데기 자동생성...


    MemberService memberService = new MemberService(new MemoryMemberRepository());


    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("1111");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}