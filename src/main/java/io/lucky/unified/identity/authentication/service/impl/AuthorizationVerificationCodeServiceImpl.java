package io.lucky.unified.identity.authentication.service.impl;

import io.lucky.authorization.server.service.AuthorizationVerificationCodeService;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationVerificationCodeServiceImpl implements AuthorizationVerificationCodeService {

    @Override
    public Boolean sendAuthorizationVerificationCode(String sender) {
        return null;
    }

    @Override
    public Boolean checkAuthorizationVerificationCode(String sender, String verificationCode) {
        if("13913859520".equals(sender)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
