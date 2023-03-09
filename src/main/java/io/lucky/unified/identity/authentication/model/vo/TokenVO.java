package io.lucky.unified.identity.authentication.model.vo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TokenVO implements Serializable {

    @SerializedName(value = "access_token",alternate = "accessToken")
    private String accessToken;

    @SerializedName(value = "token_type",alternate = "tokenType")
    private String tokenType;

    @SerializedName(value = "refresh_token",alternate = "refreshToken")
    private String refreshToken;

    @SerializedName(value = "expires_in",alternate = "expiresIn")
    private Long expiresIn;

    private String scope;


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
