package com.springboot.main.realmService;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * Description:
 * Created by Channing on 2018/1/30.
 */
public interface RealmService {
    /** 返回一个位移的Realm的名字 */
    String getName();

    /** 判断此Realm是否支持Token */
    Boolean supports(AuthenticationToken token);

    /** 根据Token获取认证信息 */
    AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException;

}
