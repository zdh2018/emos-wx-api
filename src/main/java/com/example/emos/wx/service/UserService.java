package com.example.emos.wx.service;

import java.util.Set;

/**
 * @author zdh
 * @date 2021/8/8 17:20
 */
public interface UserService {
    public int registerUser(String registerCode, String code,
                           String nickname, String photo);
    public Set<String> searchUserPermissions(int userId);
}
