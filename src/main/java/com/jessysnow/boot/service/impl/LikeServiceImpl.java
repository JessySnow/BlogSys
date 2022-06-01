package com.jessysnow.boot.service.impl;

import com.jessysnow.boot.entity.User;
import com.jessysnow.boot.mapper.LikeMapper;
import com.jessysnow.boot.service.LikeService;
import com.jessysnow.boot.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeMapper likeMapper;

    @Autowired
    public LikeServiceImpl(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }

    @Override
    public boolean cancelLikeBlog(HttpServletRequest request, long blogId) {
        User user = SessionUtil.getUserFromSession(request);
        if(likeMapper.selectLikeRecord(user.getId(), blogId) != null){
            likeMapper.deleteLikeRecord(user.getId(), blogId);
            return true;
        }
        return false;
    }

    @Override
    public boolean likeABlog(HttpServletRequest request, long blogId) {
        User user = SessionUtil.getUserFromSession(request);
        if(likeMapper.selectLikeRecord(user.getId(), blogId) == null){
            likeMapper.insertNewLike(user.getId(), blogId);
            return true;
        }
        return false;
    }
}
