package jp.co.sample.emp_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring securityを制御するクラス.
 * 
 * @author yuuki
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        // セキュリティ設定を無視するリクエスト設定
        // 静的リソースに対するアクセスはセキュリティ設定を無視する
        web.ignoring().antMatchers("/css/**", "/img/**", "/js/**","/fonts/**");
    }
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
        http
        	.authorizeRequests()
        		.antMatchers("/","/toInsert","/insert","/failure","/password_check_api/password_check").permitAll()
        		.anyRequest().authenticated();
        
        http
        	.formLogin()
        		.loginPage("/").loginProcessingUrl("/login")
        		.failureUrl("/failure").defaultSuccessUrl("/employee/showList", true)
        		.usernameParameter("mailAddress").passwordParameter("password");
     
	}
}	
