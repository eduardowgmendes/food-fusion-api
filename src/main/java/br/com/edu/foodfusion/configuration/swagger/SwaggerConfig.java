package br.com.edu.foodfusion.configuration.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private final String applicationDescription = """
            FoodFusion is a state-of-the-art point of sale (POS) system designed specifically for bars and
                    restaurants. With an intuitive interface and a comprehensive suite of features, FoodFusion streamlines your
                    operations, enhances customer experiences, and boosts overall efficiency. Key features include real-time order
                    management, seamless kitchen integration, inventory tracking, detailed sales analytics, and robust customer
                    loyalty programs. Whether you're managing a single location or multiple outlets, FoodFusion provides the
                    tools you need to succeed in the fast-paced food and beverage industry.
            """;

    @Bean
    public OpenAPI getOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Food Fusion Api")
                        .version("1.0")
                        .description(applicationDescription));
    }
}
