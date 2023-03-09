package io.lucky.unified.identity.authentication.model.request;

import com.google.gson.annotations.SerializedName;

public abstract class AbstractLoginRequest implements LoginRequest{

    public AbstractLoginRequest(String clientId, String clientSecret, String grantType) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.grantType = grantType;
    }

    @SerializedName(value = "client_id",alternate = "clientId")
    private String clientId;

    @SerializedName(value = "client_secret",alternate = "clientSecret")
    private String clientSecret;

    @SerializedName(value = "grant_type",alternate = "grantType")
    private String grantType;

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    @Override
    public String clientId() {
        return this.clientId;
    }

    @Override
    public String clientSecret() {
        return this.clientSecret;
    }

    @Override
    public String grantType() {
        return this.grantType;
    }

}
