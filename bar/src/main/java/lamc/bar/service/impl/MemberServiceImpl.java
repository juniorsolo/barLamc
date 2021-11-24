package lamc.bar.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lamc.bar.MemberRepository;
import lamc.bar.entity.Member;
import lamc.bar.service.MemberService;

/**
 * 23/11/2021
 * 
 * @author Junior.solo Coveiro
 *
 */
@Service
public class MemberServiceImpl implements MemberService {
	
	Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	MemberRepository memberRepo;
	
	@Override
	public List<Member> findAll() {
		try {
			return memberRepo.findAll();
		}catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	@Override
	public Optional<Member> findById(Integer id) {
		try {
			return memberRepo.findById(id);
		}catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
}
