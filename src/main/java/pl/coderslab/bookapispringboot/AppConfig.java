package pl.coderslab.bookapispringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.bookapispringboot.utils.DBUtill;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")

public class AppConfig implements WebMvcConfigurer {

    @Bean
    @Profile("DB")
    public DBUtill dbUtill(){
        DBUtill db = new DBUtill();
        db.setDB_USER("root");
        db.setDB_PASS("coderslab");
        db.setDB_SERVER_URL("jdbc:mysql://localhost:3306/BookAPI");
        db.setDB_PARAMS("?useSSL=false&serverTimezone=UTC&characterEncoding=utf8&allowPublicKeyRetrieval=true");
        return db;
    }

}
