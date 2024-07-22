package com.ankit.springboot.restapi;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableWebSecurity
//@ComponentScan("com.ankit.springboot.webpage")
//@EnableJpaRepositories("com.ankit.springboot.webpage.todo")
//@EntityScan("com.ankit.springboot.webpage.todo")
//@ComponentScan("com.ankit.springboot.webpage.todo")
public class RestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);

	}

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests().requestMatchers("/users/**").permitAll().anyRequest().authenticated().and()
        		.formLogin().and().build();
    }
	
	@Bean
	public DataSource datasourceProvider(){
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setUsername("root");
		ds.setPassword("Ankit1310@");
		ds.setUrl("jdbc:mysql://localhost:3306/todo");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return ds;
	}

	@Bean
	public UserDetailsService userDetail() {
//		 var dataCenter1=new JdbcUserDetailsManager();
//		 dataCenter1.setDataSource(datasourceProvider());
	
	
		

		var dataCenter = new InMemoryUserDetailsManager();
		UserDetails userDetail = User.withUsername("Ankit")
				.password("$2a$12$Tf9SSZLlGYIljN2tLNGdcO8Oy7rKTSitcNHaSL2YBGWu7Ud5wutn2").authorities("admin").build();
		dataCenter.createUser(userDetail);
		return dataCenter;
	}

	@Bean
	public PasswordEncoder password() {

		return new BCryptPasswordEncoder();
	}

}
