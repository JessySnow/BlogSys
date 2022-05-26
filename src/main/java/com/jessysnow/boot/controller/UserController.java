package com.jessysnow.boot.controller;

import com.jessysnow.boot.controller.result.Code;
import com.jessysnow.boot.controller.result.Struct;
import com.jessysnow.boot.entity.User;
import com.jessysnow.boot.service.UserService;
import com.jessysnow.boot.utils.CookieUtil;
import com.jessysnow.boot.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
    public Struct<User> test(){
        return new Struct<>(Code.SUCCESS, userService.getUserById(1));
    }

    /**
     * 登录
     * @param user 从表单构造的 user 对象
     * @return 是否登录成功的提示
     */
    @PostMapping("login")
    public Struct<String> login(@RequestBody  @Valid User user, HttpServletResponse httpServletResponse, HttpServletRequest request){
        user = userService.getUserByAuth(user.getUsername(), user.getPassword());

        if(user != null){
            SessionUtil.addUserToSession(user, request);
            return new Struct<String>(Code.SUCCESS, "认证成功");
        }else
            return new Struct<String>(Code.FAIL, "认证失败");
    }

    /**
     * 登出
     */
    @PostMapping("logout")
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        SessionUtil.removeUserFromSession(httpServletRequest);
    }

    /**
     * RESTFul
     * 获取用户的信息
     */
    @GetMapping("")
     public Struct<User> getUserInfo(HttpServletRequest httpServletRequest){
        User user = SessionUtil.getUserFromSession(httpServletRequest);
        return new Struct<>(Code.SUCCESS, user);
     }

    /**
     * RESTFul
     * 增加用户信息
     */
    @PostMapping("")
    public Struct<String> register(@RequestBody @Valid User user){
        if(!userService.checkNameRepeat(user.getUsername())){
            userService.registerUser(user.getUsername(), user.getPassword());
            return new Struct<>(Code.SUCCESS, "添加成功");
        }else{
            return new Struct<>(Code.FAIL, "添加失败，存在同名用户");
        }
    }

    /**
     * RESTFul
     * 修改用户信息
     * @return 是否修改成功的提示
     */
    @PutMapping("")
    public Struct<String> edit(String username, String password, String desc, @RequestParam("avatar") MultipartFile avatar, HttpServletRequest httpServletRequest) throws IOException {
        long id = SessionUtil.getUserFromSession(httpServletRequest).getId();

        if(userService.isNameRepeat(id, username)){
            return new Struct<>(Code.FAIL, "修改失败，存在同名用户");
        }else{
            String avatarPath = userService.updateAvatar(id, avatar, httpServletRequest);
            userService.updateUser(id, username, password, avatarPath, desc);
            SessionUtil.addUserToSession(userService.getUserById(id), httpServletRequest);
            return new Struct<>(Code.SUCCESS, "修改成功");
        }
    }
}
