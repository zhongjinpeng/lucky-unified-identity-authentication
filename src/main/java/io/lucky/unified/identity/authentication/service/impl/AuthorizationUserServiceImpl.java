package io.lucky.unified.identity.authentication.service.impl;

import io.lucky.authorization.server.service.AuthorizationUserService;
import io.lucky.security.model.LuckyRole;
import io.lucky.security.model.LuckyUser;
import io.lucky.utils.MD5Util;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorizationUserServiceImpl implements AuthorizationUserService {
    @Override
    public LuckyUser queryUserByUsername(String username) {
        LuckyUser luckyUser = new LuckyUser();
        luckyUser.setUserId(1L);
        luckyUser.setUsername("lucky");
        luckyUser.setPhone("13913859520");
        luckyUser.setPassword(MD5Util.MD5WithSalt("123456"));
        luckyUser.setEnabled(false);
        luckyUser.setLocked(false);
        luckyUser.setExpired(false);
        luckyUser.setCredentialsExpired(false);

        List<LuckyRole> roleList = new ArrayList<>();
        LuckyRole luckyRole = new LuckyRole();
        luckyRole.setRoleId(1L);
        luckyRole.setRoleCode("000001");
        luckyRole.setRoleName("测试");
        roleList.add(luckyRole);

        luckyUser.setRoleList(roleList);
        return luckyUser;

    }

    @Override
    public LuckyUser queryUserByPhone(String phone) {
        if ("13913859520".equals(phone)) {
            LuckyUser luckyUser = new LuckyUser();
            luckyUser.setUserId(1L);
            luckyUser.setUsername("lucky");
            luckyUser.setPhone("13913859520");
            luckyUser.setEnabled(false);
            luckyUser.setLocked(false);
            luckyUser.setExpired(false);
            luckyUser.setCredentialsExpired(false);

            List<LuckyRole> roleList = new ArrayList<>();
            LuckyRole luckyRole = new LuckyRole();
            luckyRole.setRoleId(1L);
            luckyRole.setRoleCode("000001");
            luckyRole.setRoleName("测试");
            roleList.add(luckyRole);

            luckyUser.setRoleList(roleList);
            return luckyUser;
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LuckyUser luckyUser = new LuckyUser();
        luckyUser.setUserId(1L);
        luckyUser.setUsername("lucky");
        luckyUser.setPhone("13913859520");
        luckyUser.setEnabled(false);
        luckyUser.setLocked(false);
        luckyUser.setExpired(false);
        luckyUser.setCredentialsExpired(false);
        luckyUser.setPassword(MD5Util.MD5WithSalt("123456"));

        List<LuckyRole> roleList = new ArrayList<>();
        LuckyRole luckyRole = new LuckyRole();
        luckyRole.setRoleId(1L);
        luckyRole.setRoleCode("000001");
        luckyRole.setRoleName("测试");
        roleList.add(luckyRole);

        luckyUser.setRoleList(roleList);
        return luckyUser;
    }
}
