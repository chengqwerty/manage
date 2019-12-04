package som.make.complete.manage.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                super.configure(http);
//                http.formLogin().successHandler(new CustomAuthenticationSuccessHandler()).failureHandler(new CustomAuthenticationFailureHandler())
//                        .and()
//                        .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint())
//                        .and()
//                        .logout().logoutSuccessHandler(new CustomLogoutSuccessHandler())
//                        .and()
//                        .csrf().disable(); // 暂时禁用，后面研究清楚了再启用
            }
        };
    }

}
