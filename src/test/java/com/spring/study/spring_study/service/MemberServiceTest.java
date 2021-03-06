package com.spring.study.spring_study.service;

import com.spring.study.spring_study.domain.Member;
import com.spring.study.spring_study.respository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {
// command + shift + t 테스트 코드 껍데기 자동생성...


    MemberService memberService;
    MemoryMemberRepository memberRepository;


    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

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

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
        String name = "Mike Standish";

        if (name.length() < 4) {
            System.out.println("false = " + false);
        }
        Pattern infoPattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{0,}[_]?[a-zA-Z0-9]{1,}$");
        Matcher infoMatcher = infoPattern.matcher(name);

        String lastCharacter = name.substring(name.length()-1);


        if(infoMatcher.find()){
            System.out.println("true = " + true);
        } else {
            System.out.println("false = " + false);
        }
    }

    @Test
    void uniquenumbers() {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer data: numbers) {
            if (map.get(data) == null) {
                map.put(data,1);
            } else {
                map.put(data,map.get(data)+1);
            }
        }
        List<Integer> result = new ArrayList<>();;
        for (Integer data: numbers) {
            if (map.get(data) == 1) {
                result.add(data);

            }
        }


    }
}