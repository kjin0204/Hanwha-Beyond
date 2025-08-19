package com.ohgiraffers.section04.testapp.Service;

import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.repository.MemberRepository;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.ArrayList;

public class MemberService {
    private final MemberRepository memberRepository = new MemberRepository();

    public void findAllMemevers() {
        List<Member> result =  memberRepository.findAllMemebers();

        System.out.println("Service에서 조회 확인 : ");
        for(Member member : result){
            System.out.println("member = " + member);
        }
    }


}
