package lamc.bar.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lamc.bar.entity.Member;
import lamc.bar.response.Response;
import lamc.bar.service.MemberService;

/**
 * 23/11/2021
 * @author junior.solo Coveiro 
 * 
 * 
 */
@RestController
@RequestMapping("api/member")
@CrossOrigin(origins = "*")
public class MemberController {
	
	Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	@GetMapping()
	public ResponseEntity<Response<List<Member>>> allMembers(){
		Response<List<Member>> response = new Response<>();
		List<Member> lista =  memberService.findAll();
		response.setData(lista);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Response<Member>> menberById(@PathVariable Integer id){
		Response<Member> response = new Response<>();
		Optional<Member> member =  memberService.findById(id);
		response.setData(member.isPresent() ? member.get() : null);
		return ResponseEntity.ok(response);
	}
}
