package ee.taltech.twentyonebackend.security;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Setter
@Component
@ConfigurationProperties(prefix = "app.jwt")
public class JwtConfig {
    private String secret = "SecretString";
    private int durationMin = 1000 ;

    public int getDurationMs() {
        return durationMin * 60 * 1000;
    }

    public String getSecret() {
        return secret;
    }
}
