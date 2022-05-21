package com.jessysnow.boot.mapper;

import com.jessysnow.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    /**
     * 从数据库中获取所有的 User 对象
     * @return User 对象集合
     */
    List<User> selectAll();

    /**
     * 从数据库获取 User 对象
     * 筛选条件 ： 用户 id
     * @return User 对象
     */
    User selectUserById(@Param("id")long id);

    /**
     * 从数据库获取 User 对象
     * 筛选条件 ： 用户 username
     * @return User 对象
     */
    User selectUserByUserName(@Param("username")String username);

    /**
     * 从数据库获取 User 对象
     * 筛选条件 用户 username && 用户 password
     * @return User 对象
     */
    User selectUserByUserInfo(@Param("username")String username, @Param("password")String password);

    /**
     * 插入一条新的用户数据
     */
    void insertNewUser(@Param("username") String username, @Param("password") String password);

    /**
     * 更新一个用户数据
     * 更新条件 : 用户 id
     */
    void updateUser(@Param("id")long id, @Param("username")String username, @Param("password") String password, @Param("avatar") String avatar);
}
