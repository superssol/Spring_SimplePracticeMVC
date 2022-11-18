package com.example.spring_simplepracticemvc;

import com.example.spring_simplepracticemvc.repository.JdbcMemberRepository;
import com.example.spring_simplepracticemvc.repository.JdbcTemplateMemberRepository;
import com.example.spring_simplepracticemvc.repository.MemberRepository;
import com.example.spring_simplepracticemvc.repository.MemoryMemberRepository;
import com.example.spring_simplepracticemvc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
