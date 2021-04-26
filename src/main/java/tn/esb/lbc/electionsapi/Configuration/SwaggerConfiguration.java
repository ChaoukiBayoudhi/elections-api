package tn.esb.lbc.electionsapi.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
        * @author Chaouki Bayoudhi
        */
@Configuration
public class SwaggerConfiguration {
    @Bean
    //le serveur va céer un composant qui sera responsable d'executer
    //la méthode ci-dessous
    public Docket ActivityApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("tn.esb.lbc"))
                .build();
    }
}
