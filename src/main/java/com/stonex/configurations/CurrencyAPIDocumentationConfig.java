package com.stonex.configurations;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class CurrencyAPIDocumentationConfig {
    public static final ApiInfo DEFAULT = new ApiInfo("Currency Api Documentation", "Currency Api Documentation", "1.0", "urn:tos", new Contact("Sai Phani", "", "EedaraSai.Phani@stonex.com"), "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    public Docket apiDoc() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT);
    }
}
