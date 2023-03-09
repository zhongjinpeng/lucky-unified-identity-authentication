package io.lucky.unified.identity.authentication.config;

import io.lucky.utils.MD5Util;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PasswordEncoderConfig implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return MD5Util.MD5WithSalt((String) charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        if (StringUtils.isEmpty(s)) {
            return false;
        }
        return MD5Util.verify((String) charSequence, s);
    }

}
