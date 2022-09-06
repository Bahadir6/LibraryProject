package com.librarymanagement.library.repo;

import com.librarymanagement.library.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Transactional
public interface MemberRepo extends JpaRepository<Member,Long> {

    public void deleteMemberById(Long id);

    Optional<Member> findMemberById(Long id);
}
