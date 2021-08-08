package com.example.emos.wx.config.shrio;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author zdh
 * @date 2021/7/29 21:26
 */
public class OAuth2Token implements AuthenticationToken {

    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {

        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
