package com.marcosstefani;

import com.stripe.StripeClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.PasswordAuthentication;

import static java.util.Objects.nonNull;

@Configuration
@EnableConfigurationProperties({StripeProperties.class})
public class StripeAutoConfiguration {
    private final StripeProperties properties;

    public StripeAutoConfiguration(StripeProperties properties) {
        this.properties = properties;
    }

    @Bean
    @Qualifier("stripeClient")
    public StripeClient stripeClient() {
        // basic builder
        var builder = StripeClient.builder()
                .setApiKey(properties.getApiKey())
                .setMaxNetworkRetries(properties.getMaxNetworkRetries())
                .setConnectTimeout(properties.getConnectTimeoutInSeconds() * 1000)
                .setReadTimeout(properties.getReadTimeoutInSeconds() * 1000);

        // add optional proxyCredential
        final var proxyCredential = properties.getProxyCredential();
        if (nonNull(proxyCredential)) {
            var authentication = new PasswordAuthentication(
                    proxyCredential.getUsername(),
                    proxyCredential.getPassword().toCharArray()
            );
            builder.setProxyCredential(authentication);
        }

        // add optional clientId
        if (nonNull(properties.getClientId()) && !properties.getClientId().isBlank()) {
            builder.setClientId(properties.getClientId());
        }

        // add optional addresses
        var address = properties.getAddress();
        if (nonNull(address)) {
            if (nonNull(address.getApiBase()) && !address.getApiBase().isBlank()) {
                builder.setApiBase(address.getApiBase());
            }

            if (nonNull(address.getConnectBase()) && !address.getConnectBase().isBlank()) {
                builder.setConnectBase(address.getConnectBase());
            }

            if (nonNull(address.getFilesBase()) && !address.getFilesBase().isBlank()) {
                builder.setFilesBase(address.getFilesBase());
            }
        }

        return builder.build();
    }
}
