package com.jessysnow.boot.mapper;

import com.jessysnow.boot.entity.Like;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LikeMapper {

    /**
     * 向数据库中插入一条新的点赞记录
     * @param userId 用户 id
     * @param blogId 博客 id
     */
    void insertNewLike(@Param("userId") long userId, @Param("blogId") long blogId);

    /**
     * 查询点赞记录
     * @param userId 用户 id
     * @param blogId 博客 id
     * @return Like 对象
     */
    Like selectLikeRecord(@Param("userId") long userId, @Param("blogId") long blogId);

    /**
     * 删除点赞记录
     * @param userId 用户 id
     * @param blogId 博客 id
     */
    void deleteLikeRecord(@Param("userId") long userId, @Param("blogId") long blogId);
}
