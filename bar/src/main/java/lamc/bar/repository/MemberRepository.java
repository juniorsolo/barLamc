package lamc.bar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lamc.bar.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	
}
