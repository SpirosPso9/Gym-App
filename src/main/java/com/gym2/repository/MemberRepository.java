package com.gym2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym2.members_program.Member;


@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
	/*
	 * 
	 * 
	 * */
}
