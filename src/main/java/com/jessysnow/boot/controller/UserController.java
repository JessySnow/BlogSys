package com.jessysnow.boot.controller;

import com.jessysnow.boot.entity.User;
import com.jessysnow.boot.service.UserService;
import com.jessysnow.boot.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/user/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("test")
    public User test(){
        return userService.getUserById(1);
    }

    /**
     * 登录
     * @param user 从表单构造的 user 对象
     * @return 是否登录成功的提示
     */
    @PostMapping("login")
    public String login(@Valid User user, BindingResult bindingResult, HttpServletResponse httpServletResponse){
        for(ObjectError error : bindingResult.getAllErrors())
            return error.getDefaultMessage();

        user = userService.getUserByAuth(user.getUsername(), user.getPassword());
        if(user != null){
            CookieUtil.addUserIdToCookie(user.getId(), httpServletResponse);
            return "认证成功";
        }else
            return "用户认证失败，检查用户名或密码";
    }

    /**
     * 登出
     */
    @PostMapping("logout")
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        CookieUtil.removeUserIdFromCookie(httpServletRequest, httpServletResponse);
    }

    /**
     * RESTFul
     * 获取用户的信息
     */
    @GetMapping("")
     public User getUserInfo(HttpServletRequest httpServletRequest){
        return userService.getUserById(CookieUtil.getUserIdFromCookie(httpServletRequest));
     }

    /**
     * RESTFul
     * 增加用户信息
     */
    @PostMapping("")
    public String register(@Valid User user, BindingResult bindingResult){
        for(ObjectError error : bindingResult.getAllErrors())
            return error.getDefaultMessage();
        if(userService.verifyUser(user)){
            userService.registerUser(user.getUsername(), user.getPassword());
            return "注册成功";
        }else{
            return "用户名已被占用";
        }
    }

    /**
     * RESTFul
     * 修改用户信息
     * @return 是否修改成功的提示
     */
    @PutMapping("")
    public String edit(String username, String password, String desc, @RequestParam("avatar") MultipartFile avatar, HttpServletRequest httpServletRequest) throws IOException {
        long id = CookieUtil.getUserIdFromCookie(httpServletRequest);
        if(userService.isNameRepeat(id, username)){
            return "用户名已经被占用，更换一个用户名后重试";
        }else{
            String avatarPath = userService.updateAvatar(id, avatar, httpServletRequest);
            userService.updateUser(id, username, password, avatarPath, desc);
            return "用户信息修改成功";
        }
    }
}
