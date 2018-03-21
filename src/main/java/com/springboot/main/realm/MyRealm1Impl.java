package com.springboot.main.realm;

import com.springboot.main.realmService.RealmService;
import org.apache.shiro.authc.*;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Created by Channing on 2018/1/30.
 */
public class MyRealm1Impl implements RealmService {

    @Override
    public String getName() {

        return "MyRealm1Impl";
    }

    @Override
    public Boolean supports(AuthenticationToken token) {

        /** 仅支持usernamePassword类型的Token */
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        /** 获得用户名 */
        String username = (String)token.getPrincipal();

        String password = new String((char[]) token.getCredentials());

        if (!"zhang".equals(username)) {
            throw new UnknownAccountException();
        }

        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException();
        }

        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
