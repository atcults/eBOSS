package org.sanelib.eboss.api.dto.client;


import org.sanelib.eboss.api.dto.BaseDTO;

public class ClientDTO extends BaseDTO {

    private String clientId;
    private String clientSecret;
    private String clientName;
    private String description;
    private String clientUrl;
    private String clientType;
    private String scope;
    private String redirectUri;
    private String registrationDate;

    public ClientDTO(){

    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClientUrl() {
        return clientUrl;
    }

    public void setClientUrl(String clientUrl) {
        this.clientUrl = clientUrl;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", clientName='" + clientName + '\'' +
                ", description='" + description + '\'' +
                ", clientUrl='" + clientUrl + '\'' +
                ", clientType='" + clientType + '\'' +
                ", scope='" + scope + '\'' +
                ", redirectUri='" + redirectUri + '\'' +
                ", regdate='" + registrationDate + '\'' +
                '}';
    }
}
