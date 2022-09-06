package com.librarymanagement.library.exception.service;

import com.librarymanagement.library.exception.UserNotFoundException;
import com.librarymanagement.library.model.Member;
import com.librarymanagement.library.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MemberService {
    private final MemberRepo memberRepo;

    @Autowired
    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public Member addMember(Member member){
        member.setMemberCode(UUID.randomUUID().toString());
        return memberRepo.save(member);
    }

    public List<Member> findAllMembers(){
        return memberRepo.findAll();
    }

    public Member updateMember(Member member){
        return memberRepo.save(member);
    }

    public Member findMemberById(Long id){
        return memberRepo.findMemberById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id" + id + "was not found"));
    }

    public void deleteMember(Long id){
        memberRepo.deleteMemberById(id);
    }


}
