package jp.co.sample.emp_management.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/password_check_api")
public class CheckPasswordApiController {
	
	@RequestMapping(value = "/password_check")
	public Map<String, String> passwordcheck(String password, String confirmPassword){
		
		Map <String, String> map = new HashMap<>();
		String confirmMessage = null;
		
		if (confirmPassword == null) {
		} else if (password.equals(confirmPassword)) {
			confirmMessage = "確認用パスワードが一致しました。";
		} else {
			confirmMessage = "確認用パスワードが一致しません。";
		}
		
		map.put("confirmMessage", confirmMessage);
		return map;
	}
}
