//package com.example.demodbcrud.service;
//
//import com.example.demodbcrud.dto.Member;
//import com.example.demodbcrud.dto.MemberEvent;
//import com.example.demodbcrud.repository.MemberRepository;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MemberService {
//
//    private final MemberRepository memberRepository;
//
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    };
//
//    public Member addMember(Member member) {
//        return memberRepository.save(member);
//    };
//
//    public Page<Member> getAllMembers(int pageNum, int count) {
//        Pageable pageable = PageRequest.of(pageNum, count);
//        Page<Member> page_1 = memberRepository.findAll(pageable);
//        return page_1;
//    };
//
//    public Page<Member> getMembers(String name, int pageNum, int count) {
//        Pageable pageable = PageRequest.of(pageNum, count);
//        Page<Member> page_1 = memberRepository.findByName(name, pageable);
//        return page_1;
//    };
//
//    // add와 update가 똑같이 쓰는 것인건가?
//    public Member updateMember(Member member) {
//        return memberRepository.save(member);
//    }
//
//
//    public void deleteMember(long memberId) {
//        memberRepository.deleteById(memberId);
//    }
//}
