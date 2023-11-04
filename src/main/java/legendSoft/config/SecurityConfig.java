package legendSoft.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("aikejan").password("aikejan").roles("Student"))
                .withUser(userBuilder.username("aizi").password("aizi").roles("Manager"))
                .withUser(userBuilder.username("mukhammed").password("mukhammed").roles("Admin","Manager"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasAnyRole("Student","Manager","Admin")
                .antMatchers("/admin-info").hasRole("Admin")
                .antMatchers("/manager-info").hasRole("Manager")
                .and().formLogin().permitAll();
    }
}
