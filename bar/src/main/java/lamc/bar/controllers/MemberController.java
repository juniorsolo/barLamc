package lamc.bar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	@GetMapping()
	public ResponseEntity<String> allMembers(){
		
		return ResponseEntity.ok("funcionou....");
	}
}
