package com.jessysnow.boot.service.impl;

import com.jessysnow.boot.entity.User;
import com.jessysnow.boot.mapper.LikeMapper;
import com.jessysnow.boot.mapper.UnLikeMapper;
import com.jessysnow.boot.service.UnLikeService;
import com.jessysnow.boot.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UnLikeServiceImpl implements UnLikeService {

    private final UnLikeMapper unLikeMapper;
    private final LikeMapper likeMapper;

    @Autowired
    public UnLikeServiceImpl(UnLikeMapper unLikeMapper, LikeMapper likeMapper) {
        this.unLikeMapper = unLikeMapper;
        this.likeMapper = likeMapper;
    }

    @Override
    public boolean cancelUnLikeBlog(HttpServletRequest request, long blogId) {
        User user = SessionUtil.getUserFromSession(request);
        if(unLikeMapper.selectUnLikeRecord(user.getId(), blogId) != null){
            unLikeMapper.deleteUnLikeRecord(user.getId(), blogId);
            return true;
        }
        return false;
    }

    @Override
    public boolean unLikeABlog(HttpServletRequest request, long blogId) {
        User user = SessionUtil.getUserFromSession(request);
        if(unLikeMapper.selectUnLikeRecord(user.getId(), blogId) == null &&
            likeMapper.selectLikeRecord(user.getId(), blogId) == null){
            unLikeMapper.insertNewUnLike(user.getId(), blogId);
            return true;
        }
        return false;
    }
}
