package lamc.bar.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lamc.bar.entity.User;
import lamc.bar.enums.ProfileEnum;
import lamc.bar.security.jwt.JwtUser;
import lamc.bar.service.UserService;


@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserService userService;
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userService.findByUserName(userName);
		
		if(user == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", userName));
		}else {
			return new JwtUser(	user.getId(), user.getUserName(), user.getPassword(), this.mapToGrantedAuthorities(user.getProfile()));
		}
	}
	
	private  List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}
}
