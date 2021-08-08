package com.example.emos.wx.controller;

import com.example.emos.wx.common.util.R;
import com.example.emos.wx.config.shrio.JwtUtil;
import com.example.emos.wx.controller.form.RegisterForm;
import com.example.emos.wx.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zdh
 * @date 2021/8/8 21:18
 */

@RestController
@RequestMapping("/user")
@Api("用户模块web接口")

public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${emos.jwt.cache-expire}")
    private int cacheExpire;

    @PostMapping("/register")
    @ApiOperation("注册用户")
    public R register(@Valid @RequestBody RegisterForm form){
        int id = userService.registerUser(form.getRegisterCode(), form.getCode(),
                form.getNickname(), form.getPhoto());
        System.out.println(id);
        String token = jwtUtil.createToken(id);
        Set<String> permsSet = userService.searchUserPermissions(id);
        saveCacheToken(token, id);
        return R.ok("用户注册成果").put("token", token).put("permission", permsSet);
    }

    private void saveCacheToken(String token, int userId){
        redisTemplate.opsForValue().set(token, userId+"",cacheExpire, TimeUnit.DAYS);
    }

}
