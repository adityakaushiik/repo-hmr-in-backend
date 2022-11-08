package in.hmr.repo.repohmrin;

import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import in.hmr.repo.repohmrin.connection.DataStaxAstraProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.nio.file.Path;

@SpringBootApplication
@EnableConfigurationProperties({DataStaxAstraProperties.class})
public class RepoHmrInApplication {
    public static void main(String[] args) {
        SpringApplication.run(RepoHmrInApplication.class, args);
    }

    @Bean
    public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
        Path bundle = astraProperties.getSecureConnectBundel().toPath();
        return (builder) -> {
            CqlSessionBuilder var10000 = (CqlSessionBuilder)builder.withCloudSecureConnectBundle(bundle);
        };
    }
}
