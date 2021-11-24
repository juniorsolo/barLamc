package lamc.bar.service;

import java.util.List;
import java.util.Optional;

import lamc.bar.entity.Member;

public interface MemberService {
	
	public List<Member> findAll();
	public Optional<Member> findById(Integer id);
}
