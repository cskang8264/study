package com.spring.study.spring_study.service;

import com.spring.study.spring_study.respository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService{

    private final MemberRepository memberRepository;

    @Override
    public void gettest() {

    }
}
