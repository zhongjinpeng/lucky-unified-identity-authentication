package io.lucky.unified.identity.authentication.model.request;

import com.google.gson.annotations.SerializedName;

public class PasswordLoginRequest extends AbstractLoginRequest{

    public PasswordLoginRequest(String clientId, String clientSecret, String grantType) {
        super(clientId, clientSecret, grantType);
    }

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
