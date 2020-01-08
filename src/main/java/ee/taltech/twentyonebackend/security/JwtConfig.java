package ee.taltech.twentyonebackend.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Setter
@Component
@ConfigurationProperties(prefix = "app.jwt")
public class JwtConfig {
    private String secret;
    private int durationMin;

    public int getDurationMs() {
        return durationMin * 60 * 1000;
    }

    public String getSecret() {
        return secret;
    }

    public int getDurationMin() {
        return durationMin;
    }
}
