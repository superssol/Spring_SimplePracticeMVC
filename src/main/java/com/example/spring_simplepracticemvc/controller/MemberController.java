package com.example.spring_simplepracticemvc.controller;

import com.example.spring_simplepracticemvc.domain.Member;
import com.example.spring_simplepracticemvc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(memberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println(form.getName() + "을 입력하였습니다.");
        memberService.join(member);

        return "redirect:/";
    }
}
