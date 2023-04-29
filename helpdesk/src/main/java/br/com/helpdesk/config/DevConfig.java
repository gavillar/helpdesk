package br.com.helpdesk.config;

import br.com.helpdesk.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @Autowired
    private DBService dbService;

    @Bean
    public boolean instanciaDB() {
        if(value.equals("create")) {
            this.dbService.instanciaDB();
        }
        return false;
    }
}
