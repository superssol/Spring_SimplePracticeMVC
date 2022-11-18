package com.example.spring_simplepracticemvc.service;

import com.example.spring_simplepracticemvc.domain.Member;
import com.example.spring_simplepracticemvc.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


//    @BeforeEach
//    public void beforeEach() {
//        memberRepository = new MemoryMemberRepository();
//        memberService = new MemberService(memberRepository);
//    }
//
//    @AfterEach
//    public void afterEach() {
//        memberRepository.clearStore();
//    }

    @Test
    void join() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        //when
        Long saveId = memberService.join(member1);

        //then
        Member findMember = memberService.findOneMember(saveId).get();
        assertThat(member1.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

/*        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/
        //then


    }
//    @Test
//    void findOneMember() {
//    }
//
//    @Test
//    void findMembers() {
//    }

}