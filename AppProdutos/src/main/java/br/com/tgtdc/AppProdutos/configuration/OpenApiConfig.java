package br.com.tgtdc.AppProdutos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
				.components(
						new Components().addSecuritySchemes("basicScheme",
								new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")
								)
						)
				.info(
						new Info()
							.title("App de cadastro de produtos e estoque")
							.description("Este app faz controle de cadastro de produtos bem como o cadastro e controle de estoque")
							.contact(new Contact()
										.name("Thiago Castro")
										.email("thiagogyorgy.castro@gmail.com")
										.url("http://github.com/ThiCastroo")
										)
							.version("Versão 0.0.1-SNAPSHOT")
						);
	}
	
}
