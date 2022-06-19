package com.spring.study.spring_study.respository;

import com.spring.study.spring_study.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    // 테스트를 모두 실행할시, 순서 보장안됨 그래서 데이터를 클리어 해주는 작업이 필요함.
    // @AfterEach // 각각 테스트가 끝나고 실행되는 메소드
    // 지금은 store 메모리초기화 용도

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("junit5");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result); //기대하는 값, 실제테스트진행한 값 jupiter package
        assertThat(member).isEqualTo(result); // //기대하는 값, 실제테스트진행한 값 assertJ package, 김영한님 pick

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring");
        repository.save(member1);
  //shift + F6 개꿀팁이다..;
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Optional<Member> resultOptional = repository.findByName("spring");
        Member result = resultOptional.get();

        assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring");
        repository.save(member1);
        //shift + F6 개꿀팁이다..;
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> all = repository.findAll();

        assertThat(all.size()).isEqualTo(2);

        for (Member member : all) {
            System.out.println("member = " + member);
        }



    }

}