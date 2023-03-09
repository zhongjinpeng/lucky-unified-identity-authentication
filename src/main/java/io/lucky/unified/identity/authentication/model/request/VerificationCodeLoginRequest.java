package io.lucky.unified.identity.authentication.model.request;

import com.google.gson.annotations.SerializedName;

public class VerificationCodeLoginRequest extends AbstractLoginRequest{

    public VerificationCodeLoginRequest(String clientId, String clientSecret, String grantType) {
        super(clientId, clientSecret, grantType);
    }

    private String sender;

    @SerializedName(value = "verification_code",alternate = "verificationCode")
    private String verificationCode;

    public String getPhone() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
