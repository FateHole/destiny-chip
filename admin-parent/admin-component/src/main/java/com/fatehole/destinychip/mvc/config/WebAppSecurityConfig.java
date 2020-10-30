package com.fatehole.destinychip.mvc.config;

import com.fatehole.destinychip.constant.DestinyChipConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author FateCat
 * @version 2020-10-28-12:31
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService)
                .passwordEncoder(getPassword());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin/login")
                .permitAll()
                .antMatchers("/static/**")
                .permitAll()
                .antMatchers("/admin/getPageInfo")
                // .hasRole("经理")
                .access("hasRole('经理') or hasAuthority('user:get')")
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest request,
                                       HttpServletResponse response,
                                       AccessDeniedException accessDeniedException
                    ) throws IOException, ServletException {

                        request.setAttribute("exception", new Exception(DestinyChipConstant.MESSAGE_ACCESS_DENIED));
                        request.getRequestDispatcher("/WEB-INF/pages/error/system-error.jsp").forward(request, response);
                    }
                })
                .and()
                .csrf().disable()
                .formLogin()
                .loginPage("/admin/login")
                .loginProcessingUrl("/security/do/login")
                .defaultSuccessUrl("/admin/main")
                .usernameParameter("loginAccount")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/security/do/logout")
                .logoutSuccessUrl("/admin/login")
                ;
    }

    @Bean
    public PasswordEncoder getPassword() {
        return new BCryptPasswordEncoder();
    }
}
