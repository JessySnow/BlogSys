package com.jessysnow.boot.mapper;

import com.jessysnow.boot.entity.UnLike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UnLikeMapper {

    /**
     * 向数据库中插入一条新的点踩记录
     * @param userId 用户 id
     * @param blogId 博客 id
     */
    void insertNewUnLike(@Param("userId") long userId, @Param("blogId") long blogId);


    /**
     * 查询点踩记录
     * @param userId 用户 id
     * @param blogId 博客 id
     * @return UnLike 对象
     */
    UnLike selectUnLikeRecord(@Param("userId") long userId, @Param("blogId") long blogId);

    /**
     * 删除点踩记录
     * @param userId 用户 id
     * @param blogId 博客 id
     */
    void deleteUnLikeRecord(@Param("userId") long userId, @Param("blogId") long blogId);

    /**
     * 获取博客点踩数量
     * @param blogId 博客 id
     * @return long 博客的点踩数
     */
    long selectUnLikeCount(@Param("blogId") long blogId);
}
