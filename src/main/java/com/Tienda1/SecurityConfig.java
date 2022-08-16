package com.gimnasio;

import com.Tienda1.Service.UsuarioDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired    
    UsuarioDetailsServiceImpl userDetailsService;
    //El siguiente método funciona para hacer la auttenticación del usuario
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
//                .withUser("Admin")
//                .password("{noop}123")
//                .roles("ADMIN", "VENDEDOR")
//                .and()
//                .withUser("rebeca")
//                .password("{noop}123")
//                .roles("VENDEDOR")
//                .and()
//                .withUser("pedro")
//                .password("{noop}123")
////                .roles("USER");
                    auth.userDetailsService(userDetailsService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/articulo/nuevo",        "/articulo/guardar", 
                             "/articulo/modificar/**", "/articulo/eliminar/**",
                             "/categoria/nuevo",       "/categoria/guardar",
                             "/categoria/modificar/**","/categoria/eliminar/**",
                             "/cliente/nuevo",         "/cliente/guardar",  
                             "/cliente/modificar/**",  "/cliente/eliminar/**",
                             "/usuario/listado",  
                             "/usuario/nuevo",         "/usuario/guardar",  
                             "/usuario/modificar/**",  "/usuario/eliminar/**")
                    .hasRole("ADMIN")
                .antMatchers("/articulo/listado", "/categoria/listado",
                             "/cliente/listado")
                    .hasAnyRole("ADMIN","VENDEDOR")
                .antMatchers("/")
                    .hasAnyRole("USER","VENDEDOR","ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403");
    } 
}
