package com.elara;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("stripe")
public class StripeProperties {
    private String apiKey;
    private String clientId;
    private int maxNetworkRetries = 2;
    private int connectTimeoutInSeconds = 30;
    private int readTimeoutInSeconds = 80;
    private ProxyCredential proxyCredential;
    private Address address;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getMaxNetworkRetries() {
        return maxNetworkRetries;
    }

    public void setMaxNetworkRetries(int maxNetworkRetries) {
        this.maxNetworkRetries = maxNetworkRetries;
    }

    public int getConnectTimeoutInSeconds() {
        return connectTimeoutInSeconds;
    }

    public void setConnectTimeoutInSeconds(int connectTimeoutInSeconds) {
        this.connectTimeoutInSeconds = connectTimeoutInSeconds;
    }

    public int getReadTimeoutInSeconds() {
        return readTimeoutInSeconds;
    }

    public void setReadTimeoutInSeconds(int readTimeoutInSeconds) {
        this.readTimeoutInSeconds = readTimeoutInSeconds;
    }

    public ProxyCredential getProxyCredential() {
        return proxyCredential;
    }

    public void setProxyCredential(ProxyCredential proxyCredential) {
        this.proxyCredential = proxyCredential;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static class ProxyCredential {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class Address {
        private String apiBase;
        private String connectBase;
        private String filesBase;

        public String getApiBase() {
            return apiBase;
        }

        public void setApiBase(String apiBase) {
            this.apiBase = apiBase;
        }

        public String getConnectBase() {
            return connectBase;
        }

        public void setConnectBase(String connectBase) {
            this.connectBase = connectBase;
        }

        public String getFilesBase() {
            return filesBase;
        }

        public void setFilesBase(String filesBase) {
            this.filesBase = filesBase;
        }
    }
}
