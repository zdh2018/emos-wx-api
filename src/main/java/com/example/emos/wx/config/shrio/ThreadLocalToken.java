package com.example.emos.wx.config.shrio;

import org.springframework.stereotype.Component;

/**
 * @author zdh
 * @date 2021/7/29 21:50
 */

@Component
public class ThreadLocalToken {
    private ThreadLocal<String> local = new ThreadLocal<>();

    public void setToken(String token){
        local.set(token);
    }
    public String getToken(){
        return (String) local.get();
    }

    public void clear(){
        local.remove();
    }

}
