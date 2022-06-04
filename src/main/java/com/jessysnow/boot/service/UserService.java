package com.jessysnow.boot.service;

import com.jessysnow.boot.entity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface UserService {
    /**
     * 验证当前用户是否存在，或者用户名密码是否匹配
     * @param user 用户对象
     * @return 匹配 -> true
     *         失配 -> false
     */
    boolean verifyUser(User user);

    /**
     * 判断当前的用户名是否已经被除了本用户以外的其他用户占用
     * @return 已存在 -> true
     *         不存在 -> false
     */
    boolean isNameRepeat(long id, String username);

    /**
     * 判断该用户名是否已经存在
     * @return 已存在 -> true
     *         不存在 -> false
     */
    boolean checkNameRepeat(String username);

    /**
     * 通过用户 id 获取一个用户的
     * @param id 用户 id
     * @return 用户对象
     */
    User getUserById(long id);

    /**
     * 通过认证信息获取一个用户
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    User getUserByAuth(String username, String password);

    /**
     * 注册一个新用户
     * @param username 用户名
     * @param password 密码
     */
    void registerUser(String username, String password);

    /**
     * 修改一个用户
     * @param username 用户名
     * @param password 密码
     */
    void updateUser(long id,  String username, String password, String avatar, String desc);

    /**
     * 对用户头像修改的处理
     * @param id 用户 id
     * @param avatar 用户头像
     */
    String updateAvatar(long id, MultipartFile avatar, HttpServletRequest httpServletRequest) throws IOException;

    /**
     * 获取博客的作者
     * @param blogId 博客 id
     * @return 博客的作者
     */
    User getBlogAuthor(long blogId);
}
