package jp.co.sample.emp_management.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.sample.emp_management.repository.AdministratorRepository;

@RestController
@RequestMapping("/mailaddress_check_api")
public class CheckMailAddressApiController {
	
	@Autowired
	private AdministratorRepository administratorRepository;
	
	@RequestMapping("/mailaddress_check")
	public Map<String, String> mailaddresscheck(String mailAddress){ 
		
		Map<String, String> map = new HashMap<>();
		String duplicateMessage = null;
		
		if (administratorRepository.findByMailAddress(mailAddress) != null ) {
			duplicateMessage = "このメールアドレスは既に使用されています。";
		} else {
			duplicateMessage = "このメールアドレスは使用可能です。";
		}
		map.put("duplicateMessage", duplicateMessage);
		return map;
	}
	
}
