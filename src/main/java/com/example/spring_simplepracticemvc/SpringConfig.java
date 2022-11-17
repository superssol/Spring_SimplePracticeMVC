package com.example.spring_simplepracticemvc;

import com.example.spring_simplepracticemvc.repository.MemberRepository;
import com.example.spring_simplepracticemvc.repository.MemoryMemberRepository;
import com.example.spring_simplepracticemvc.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
