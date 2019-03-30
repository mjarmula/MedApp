package pl.miloszjarmula.medapp.securityConfig;


//@Configuration
//@EnableWebSecurity
public class SecurityConfig //extends WebSecurityConfigurerAdapter {
{
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("receptionist").password("receptionist").roles("USER")
//                .and()
//                .withUser("admin").password("admin").roles("ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests() // potem to gowno csrf().disable do usuniecia
//                .antMatchers("/admin").hasRole("ADMIN")
//                .anyRequest().permitAll()
//                .and().formLogin();
//        http.csrf().disable()
//    }
}
