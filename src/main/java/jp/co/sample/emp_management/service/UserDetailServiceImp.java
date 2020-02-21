package jp.co.sample.emp_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.sample.emp_management.domain.Administrator;
import jp.co.sample.emp_management.domain.LoginUser;
import jp.co.sample.emp_management.repository.AdministratorRepository;

@Service
public class UserDetailServiceImp implements UserDetailsService {
	
	@Autowired
	private AdministratorRepository administratorRepository;
	
	@Override
	public UserDetails loadUserByUsername(String mailAddress) throws UsernameNotFoundException {
		
		Administrator user = null;
		
		try {
			user = administratorRepository.findByMailAddress(mailAddress);
		} catch (Exception e) {
			throw new UsernameNotFoundException("It can not be acquired User");
		}
		
		if(user == null){
            throw new UsernameNotFoundException("User not found for login id: " + mailAddress);
        }
		
		return new LoginUser(user);
	}
	
}
