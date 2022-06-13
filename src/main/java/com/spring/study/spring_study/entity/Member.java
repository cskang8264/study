package com.spring.study.spring_study.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private int age;
}
