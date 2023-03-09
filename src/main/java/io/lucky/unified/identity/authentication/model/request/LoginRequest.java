package io.lucky.unified.identity.authentication.model.request;

public interface LoginRequest{

    String clientId();

    String clientSecret();

    String grantType();

}
