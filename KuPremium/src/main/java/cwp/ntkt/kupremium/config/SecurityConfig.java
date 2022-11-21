package cwp.ntkt.kupremium.config;

import cwp.ntkt.kupremium.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImp userDetailsServiceImp;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/signup",
                        "/css/**", "/js/**").permitAll()
                .antMatchers("/menu/add")
                .access("hasRole('ROLE_ADMIN')")
                .antMatchers("/menu")
                .access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .anyRequest().authenticated()

                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .permitAll();

//        http.inMemoryAuthentication()
//                .withUser("user").password(encoder().encode("user")).roles("ROLE_USER")
//                .and()
//                .withUser("user1").password(encoder().encode("user1")).roles("ROLE_USER")
//                .and()
//                .withUser("admin").password(encoder().encode("admin")).roles("ROLE_ADMIN");
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }
}