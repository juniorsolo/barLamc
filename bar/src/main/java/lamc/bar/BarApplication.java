package lamc.bar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "lamc.bar.security.config,lamc.bar.security.jwt,lamc.bar.security.service,lamc.bar.service,lamc.bar")

public class BarApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarApplication.class, args);
	}

//	@Bean
//    public PasswordEncoder  passwordEncoder2() {
//        return new BCryptPasswordEncoder();
//    }
//
//	@Bean
//	CommandLineRunner init(UserRepository userRepository) {
//		return args -> {
//			initUsers(userRepository);
//		};
//	}
//	
//	
//	private void initUsers(UserRepository userRepository) {
//		User admin = new User();
//		admin.setUserName("coveiro");
//		admin.setPassword( passwordEncoder2().encode("123"));
//		admin.setProfile(ProfileEnum.ROLE_ADMIN);
//		
//		User paymaster = new User();
//		paymaster.setUserName("marcelino");
//		paymaster.setPassword(passwordEncoder2().encode("123"));
//		paymaster.setProfile(ProfileEnum.ROLE_PAYMASTER);
//		
//		User stockholder = new User();
//		stockholder.setUserName("edh");
//		stockholder.setPassword(passwordEncoder2().encode("123"));
//		stockholder.setProfile(ProfileEnum.ROLE_STOCKHOLDER);
//		
//		User find = userRepository.findByUserName("coveiro");
//		if(find == null) {
//			userRepository.save(admin);
//			userRepository.save(paymaster);
//			userRepository.save(stockholder);
//		}
//	}
}
