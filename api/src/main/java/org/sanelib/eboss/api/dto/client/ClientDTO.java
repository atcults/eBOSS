package org.sanelib.eboss.api.dto.client;


import org.sanelib.eboss.api.dto.BaseDTO;

public class ClientDTO extends BaseDTO {

    private String client_secret;
    private String client_name;
    private String description;
    private String client_url;
    private String client_type;
    private String scope;
    private String redirect_uri;
    private String regdate;

    public ClientDTO(){

    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClient_url() {
        return client_url;
    }

    public void setClient_url(String client_url) {
        this.client_url = client_url;
    }

    public String getClient_type() {
        return client_type;
    }

    public void setClient_type(String client_type) {
        this.client_type = client_type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                " client_secret='" + client_secret + '\'' +
                ", client_name='" + client_name + '\'' +
                ", description='" + description + '\'' +
                ", client_url='" + client_url + '\'' +
                ", client_type='" + client_type + '\'' +
                ", scope='" + scope + '\'' +
                ", redirect_uri='" + redirect_uri + '\'' +
                ", regdate='" + regdate + '\'' +
                '}';
    }
}
