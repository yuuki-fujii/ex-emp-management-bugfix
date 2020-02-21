package jp.co.sample.emp_management.domain;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class LoginUser extends User{
	
	
	private static final long serialVersionUID = 1L;
	
	private final Administrator administrator;
	
	public LoginUser(Administrator user) {
		super(user.getMailAddress(),user.getPassword(),
				AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.administrator = user;
	}
	
	public Administrator getUser() {
		return administrator;
	}
	
}
