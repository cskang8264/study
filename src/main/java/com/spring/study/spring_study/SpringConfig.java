package com.spring.study.spring_study;

import com.spring.study.spring_study.respository.MemberRepository;
import com.spring.study.spring_study.respository.MemoryMemberRepository;
import com.spring.study.spring_study.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//java 코드로 bean 등록하는 법
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

// db를 바꿀경우 여기만 손대면 컨트롤러, 서비스단은 건들이지 않아도 되는 장점이있다
}
