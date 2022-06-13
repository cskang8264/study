package com.spring.study.spring_study.respository;

import com.spring.study.spring_study.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
