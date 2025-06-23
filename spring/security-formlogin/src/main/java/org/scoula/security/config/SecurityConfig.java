package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
@Log4j2
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@RequiredArgsConstructor
@ComponentScan(basePackages = {"org.scoula.security"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 생성자 주입
    private final UserDetailsService userDetailsService;

    // 문자셋 필터
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* csrf 토큰을 깨지지 않게 하기 위해 인코딩 하는 것임 */
        // csrf 필터를 거치기 전에 encodingFilter를 만나라고 지정하는 것을 의미.
        http.addFilterBefore(encodingFilter(), CsrfFilter.class);

        // 경로별, 접근 권한 설정
        // API 만들 때 이 설정 해주어야 함.
        http.authorizeRequests()
                .antMatchers("/security/all").permitAll() // 모든 권한 접근 허용
                .antMatchers("/security/member").access("hasAnyRole('ROLE_MEMBER','ROLE_ADMIN')")
                .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')"); // ROLE_ADMIN만 접근 가능

        http.formLogin() // form 기반 로그인 활성화
                .loginPage("/security/login") // 사용자가 보게 될 로그인 페이지 (우리가 만든 거)
                .loginProcessingUrl("/security/login") // 로그인 폼에서 제출되는 URL(post)
                .defaultSuccessUrl("/");

        http.logout()
                .logoutUrl("/security/logout") // Spring Security에서 로그아웃 요청을 받는 POst API
                .invalidateHttpSession(true)
                .deleteCookies("JSESSION-ID")
                .logoutSuccessUrl("/security/logout"); // GET logout 페이지로 전환

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)throws Exception {
//        log.info("configure .........................................");
//        // inMemoryAuthentication -> 메모리 상에 User 정보를 임의로 등록
//        auth.inMemoryAuthentication()
//                .withUser("admin")
////                .password("{noop}1234")
//                // {noop} : security는 기본적으로 비번 암호화 필수 --> 예외 처리시킴
//                .password("$2a$10$EsIMfxbJ6NuvwX7MDj4WqOYFzLU9U/lddCyn0nic5dFo3VfJYrXYC")
//                .roles("ADMIN", "MEMBER"); // ROLE_ADMIN
//
//        auth.inMemoryAuthentication()
//                .withUser("member")
////                .password("{noop}1234")
//                .password("$2a$10$EsIMfxbJ6NuvwX7MDj4WqOYFzLU9U/lddCyn0nic5dFo3VfJYrXYC")
//                .roles("MEMBER"); // ROLE_MEMBER
//
//    }

    // 직접 만든 userDetailsService를 이용해 인증을 진행하도록 설정
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception {
        log.info("configure .........................................");
        // inMemoryAuthentication -> 메모리 상에 User 정보를 임의로 등록
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

}
