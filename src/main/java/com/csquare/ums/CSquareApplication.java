package com.csquare.ums;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.csquare.ums.dao.UserMasterRepository;
import com.csquare.ums.model.UserInfo;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
public class CSquareApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(CSquareApplication.class, args);
	}


	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CSquareApplication.class);
	}

	
	 			
	
	 
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserMasterRepository userDetailRepository)
			throws Exception {
		
		builder.userDetailsService(new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
				List<GrantedAuthority> auths = new ArrayList<>();
				if(Objects.nonNull(userName) && userName.startsWith("admin")) {
					String userInfo[] = userName.split(":");
					
					com.csquare.ums.model.UserMaster userDetails = userDetailRepository.findUserMasterByUserName(userInfo[0]);
					return new UserInfo(userDetails.getUsername(),userDetails.getPassword(),userDetails,auths);
				}else {
					String userAuthFields[] = userName.split(":");
					//HierarchyMaster company = hierarchyMasterRepository.findOne(Long.valueOf(userAuthFields[1]));
					//com.nmbr.diamond.entity.UserMaster userDetails = userDetailRepository.findUserMasterByUserNameAndCompany(userAuthFields[0],company);
					com.csquare.ums.model.UserMaster userDetails = userDetailRepository.findUserMasterByUserName(userAuthFields[0]);
					if (Objects.isNull(userDetails)) {
						throw new UsernameNotFoundException("Username not found");
					}
					
//					Set<UserRole> roles = userDetails.getUserRoles();
//					for (UserRole userRole : roles) {
//						auths.add(new SimpleGrantedAuthority(userRole.getRoleMaster().getRoleName()));
//					}
//					
					return new UserInfo(userDetails.getUsername(),
							userDetails.getPassword(),userDetails, auths);
				}
				
			}
		});//.passwordEncoder(passwordEncoder());

	}
}
