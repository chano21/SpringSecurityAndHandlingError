package com.security.app.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.app.tables.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByUemail(String email);
}