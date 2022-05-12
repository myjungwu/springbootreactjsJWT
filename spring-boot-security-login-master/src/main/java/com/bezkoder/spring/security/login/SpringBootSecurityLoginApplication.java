package com.bezkoder.spring.security.login;

import com.bezkoder.spring.security.login.models.ERole;
import com.bezkoder.spring.security.login.models.Role;
import com.bezkoder.spring.security.login.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootSecurityLoginApplication {
	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityLoginApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() {
		return new ApplicationRunner() {
			@Override
			public void run(ApplicationArguments args) throws Exception {
				//Role  객체생성
				List<Role> roleList = Arrays.asList(new Role(ERole.ROLE_USER), new Role(ERole.ROLE_ADMIN), new Role(ERole.ROLE_MODERATOR));
				//db에 insert
				List<Role> savedRoleList = roleRepository.saveAll(roleList);
				//확인
				savedRoleList.forEach(role -> System.out.println(role.getName()));
			}//run
		};
	}

}
