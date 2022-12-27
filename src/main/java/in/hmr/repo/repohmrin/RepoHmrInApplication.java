package in.hmr.repo.repohmrin;

import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.datastax.oss.driver.api.core.config.DefaultDriverOption;
import in.hmr.repo.repohmrin.connection.DataStaxAstraProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.autoconfigure.cassandra.DriverConfigLoaderBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableConfigurationProperties({DataStaxAstraProperties.class})
public class RepoHmrInApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(RepoHmrInApplication.class, args);
    }

    @Bean
    public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
        Path bundle = astraProperties.getSecureConnectBundel().toPath();
        return (builder) -> {
            CqlSessionBuilder var10000 = (CqlSessionBuilder) builder.withCloudSecureConnectBundle(bundle);
        };
    }

    @Bean
    public DriverConfigLoaderBuilderCustomizer defaultProfile() {
        return builder -> builder.withString(DefaultDriverOption.METADATA_SCHEMA_REQUEST_TIMEOUT, "3 seconds").build();
    }
}
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // Register resource handler for images
//        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
//                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
//    }
