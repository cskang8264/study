package com.spring.study.spring_study.service;


import com.spring.study.spring_study.domain.Member;
import com.spring.study.spring_study.respository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;

    /**
     * 회원가입
     * @param member
     * @return
     */
    public Long join(Member member) {
        validateDuplicateMeber(member); // 간단한 중복회원 검증
        memberRepository.save(member);
        return member.getId();

    }
    // command + option + m 메소드 따로뺴는 단축키... 개꿀..
    private void validateDuplicateMeber(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        // 이전에 나는 if(Objects.isNull(객체)) 이런식으로 했는데 Optional로 감싸진 객채를 쓰면
        // 아래와 같이 ifPresent 같은 메소드 사용가능 java 8부터
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 계정입니다.");
        });
    }

    /**
     * 전체 회원 조회
     * @return
     * List<Member>
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원조회 by id
     * @param id
     * @return member
     */
    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);
    }
}
