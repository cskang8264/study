package com.spring.study.spring_study.respository;

import com.spring.study.spring_study.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    // optional 잘써야겠구먼...;
    private static Map<Long, Member> store = new HashMap<>();
    //동시성 문제(멀티쓰레딩)을 생각하면 ConcurentHashMap이 적절
    private static long sequence = 0L;
    //동시성 문제(멀티쓰레딩)을 생각하면 AtomicLong이 적절

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
