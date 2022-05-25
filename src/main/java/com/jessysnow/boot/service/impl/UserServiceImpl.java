package com.jessysnow.boot.service.impl;

import com.jessysnow.boot.entity.User;
import com.jessysnow.boot.mapper.UserMapper;
import com.jessysnow.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean checkNameRepeat(String username) {
        return userMapper.selectUserByUserName(username) != null;
    }

    @Override
    public boolean verifyUser(User user) {
        return userMapper.selectUserByUserInfo(user.getUsername(), user.getPassword()) != null;
    }

    @Override
    public User getUserById(long id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public User getUserByAuth(String username, String password) {
        return userMapper.selectUserByUserInfo(username, password);
    }

    @Override
    public void registerUser(String username, String password) {
        userMapper.insertNewUser(username, password);
    }

    @Override
    public void updateUser(long id, String username, String password, String avatar, String desc) {
        userMapper.updateUser(id, username, password, avatar, desc);
    }

    @Override
    public boolean isNameRepeat(long id, String username) {
        User user = userMapper.selectUserByUserName(username);
        if(user == null || user.getId() == id) return false;
        return true;
    }

    @Override
    public String updateAvatar(long id, MultipartFile avatar, HttpServletRequest httpServletRequest) throws IOException {
        String pathToSave = ResourceUtils.getURL("classpath:").getPath() + "/static/photo/";
        String photoName = pathToSave + avatar.getOriginalFilename();

        avatar.transferTo(new File(photoName));

        return "/photo/" + avatar.getOriginalFilename();
    }
}
