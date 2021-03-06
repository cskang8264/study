package com.spring.study.spring_study.service;

import com.spring.study.spring_study.domain.Member;
import com.spring.study.spring_study.respository.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest

@Transactional //test code  트랜잭셔널 추가하면 롤백이 일어나서, 기존 디비에 영향을 주지 않음!!
public class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemoryMemberRepository memberRepository;

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
    void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));// 통과 assertThrow는 예외가 반환됨
//        assertThrows(NullPointerException.class, () -> memberService.join(member2));// 안됨 -> 기대되는 예외가  IllegalStateException 이기 때문 멤버서비스 참고

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 계정입니다.");

//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 계정입니다.");
//        }




        //then
    }







}
