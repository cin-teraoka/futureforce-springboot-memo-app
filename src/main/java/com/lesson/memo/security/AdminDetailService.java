package com.lesson.memo.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lesson.memo.model.Admin;
import com.lesson.memo.repository.AdminRepository;

@Service
public class AdminDetailService implements UserDetailsService {

	private final AdminRepository adminRepository;
	
	public AdminDetailService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO 自動生成されたメソッド・スタブ
		
		System.out.println("★loadUserByUsernameに届いた値: [" + username + "]");
		
		Admin admin = adminRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found" + username));
		return new org.springframework.security.core.userdetails.User(
				admin.getEmail(), 
				admin.getPassword(),
				AuthorityUtils.createAuthorityList("ROLE_ADMIN")
				);
	}

}
