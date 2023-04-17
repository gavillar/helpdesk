package br.com.helpdesk.config;

import br.com.helpdesk.security.JWTAuthenticationFilter;
import br.com.helpdesk.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


// Essa Classe é responsável por configurar toda regra de segurança do JTW na api.


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Liberando acesso ao h2
    private static final String[] PUBLIC_MATCHERS = { "/h2-console/**" };

    // Instância do env
    @Autowired
    private Environment env;

    // Instância do jwtUtil
    @Autowired
    private JWTUtil jwtUtil;

    // Instância do userDetailsService interface
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //Garantinado o csrf não inicie.
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        if(Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        // Desabilitando o cors desabilitando e csfr
        http.cors().disable().csrf().disable();


        http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));

        http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated();




    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    // Anotação Bean para quando executar a configuração inciar.
    @Bean
    CorsConfigurationSource corsConfigurationSource() {

        // Definindo a configuração personalizada para cors.
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();

        // Definindo uma lista de métodos que serão liberados.
        configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));

        // Instância da base de cors
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Definindo de qual fonte deve receber requisições.
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
