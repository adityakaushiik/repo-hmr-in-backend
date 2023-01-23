package in.hmr.repo.repohmrin.connection;

import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "datastax.astra")
public class DataStaxAstraProperties {
    private File secureConnectBundel;

    public File getSecureConnectBundel() {
        return this.secureConnectBundel;
    }

    public void setSecureConnectBundel(File secureConnectBundel) {
        this.secureConnectBundel = secureConnectBundel;
    }

    public boolean getMetricsEnabled() {
        return false;
    }
}
