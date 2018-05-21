//package com.dtu.firstreal.config;
//
//import com.dtu.firstreal.security.UserDetailsServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//   // @Autowired
//   // private UserDetailsService userDetailsService;
//
//    //@Autowired
//   // ObjectMapper objectMapper;
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsServiceImpl();
//    }
//    @Bean
//    public SavedRequestAwareAuthenticationSuccessHandler successHandler() {
//        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
//        successHandler.setTargetUrlParameter("/secure/");
//        return successHandler;
//    }
//    @Bean
//    public SimpleUrlAuthenticationFailureHandler failureHandler() {
//        SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler("/login/loginFail");
//        failureHandler.setUseForward(true);
//        return failureHandler;
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors().and().csrf().disable()
//                .authorizeRequests()
//
//                .antMatchers("/transaction/save/*", "/transaction/finish/*", "/transaction/destroy/*").authenticated()
//                .antMatchers("/**").permitAll()
//              //  .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin()
////                .loginPage("/login")
//                .loginProcessingUrl("/login")
//                .failureHandler(failureHandler())
//                .successHandler(successHandler()) // autowired or defined below
////                .loginPage("/login")
////                .failureForwardUrl("/loginFail")
//
//                .and()
//
//              //  .addFilter(new JWTAuthenticationFilter(authenticationManager(), objectMapper))
//               // .addFilter(new JWTAuthorizationFilter(authenticationManager()))
//                .sessionManagement()
//                .sessionCreationPolicy(
//                        SessionCreationPolicy.STATELESS
//                );
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService()).passwordEncoder(bCryptPasswordEncoder());
//    }
//
//    @Bean
//    CorsConfigurationSource corsConfigurationSource(){
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//        return source;
//    }
//}
