package jp.co.sample.emp_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
        web.ignoring().antMatchers("/css/**", "/img/**", "/js/**");
    }
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
        http
        	.authorizeRequests()
        		.antMatchers("/","/toInsert","/insert").permitAll()
        		.anyRequest().authenticated();
        
        http
        	.formLogin()
        		.loginPage("/").loginProcessingUrl("/login")
        		.failureUrl("/?error").defaultSuccessUrl("/employee/showList", true)
        		.usernameParameter("mailAddress").passwordParameter("password");
        
        
	}
}	
