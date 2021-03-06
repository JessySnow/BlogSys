package com.jessysnow.boot.service.impl;

import com.jessysnow.boot.entity.Banner;
import com.jessysnow.boot.entity.Blog;
import com.jessysnow.boot.entity.vo.BlogWrapper;
import com.jessysnow.boot.mapper.BlogMapper;
import com.jessysnow.boot.service.BlogService;
import com.jessysnow.boot.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogMapper blogMapper;

    @Override
    public List<BlogWrapper> getLastNineBlogWrappers() {
        List<BlogWrapper> blogWrapperList = blogMapper.selectLastNineBlogWrappers();
        for(BlogWrapper bw : blogWrapperList){
            bw.setOutline(getOutLine(bw.getContent()));
        }
        return blogWrapperList;
    }

    @Autowired
    public BlogServiceImpl(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @Override
    public List<Blog> getAll() {
        return blogMapper.selectAll();
    }

    @Override
    public List<Blog> getLastNineBlogs() {
        return blogMapper.selectLastNineBlogs();
    }

    @Override
    public List<BlogWrapper> getBlogByCategoryValue(String category) {
        return blogMapper.selectBlogWrapperByCategoryName(category);
    }

    @Override
    public List<BlogWrapper> getUserBlogs(long userId) {
        List<BlogWrapper> blogWrapperList = blogMapper.selectBlogWrapperByUserId(userId);
        for(BlogWrapper blogWrapper : blogWrapperList)
            blogWrapper.setOutline(getOutLine(blogWrapper.getContent()));
        return blogWrapperList;
    }

    @Override
    public Blog getBlogById(long id) {
        return blogMapper.selectBlogById(id);
    }

    @Override
    public void pubANewBlog(String title, String content, int categoryId, HttpServletRequest request, String categoryValue) {
        String banner = chooseABanner(categoryValue).getPath();
        blogMapper.insertANewBlog(title, content, categoryId, SessionUtil.getUserFromSession(request).getId(), banner);
    }

    @Override
    public Banner chooseABanner(String categoryValue) {
        Banner banner = null;

        switch (categoryValue){
            case ("??????"):
                banner = Banner.TECH;
                break;
            case ("??????"):
                banner = Banner.HEALTH;
                break;
            case ("??????"):
                banner = Banner.AFFECTION;
                break;
            case ("??????"):
                banner = Banner.ANI;
                break;
            case ("??????"):
                banner = Banner.GAME;
                break;
            case ("??????"):
                banner = Banner.RUMOR;
                break;
            case ("??????"):
                banner = Banner.TEST;
                break;
            case ("??????"):
                banner = Banner.FOOD;
                break;
            case ("??????"):
                banner = Banner.TRAVEL;
                break;
            case ("??????"):
                banner = Banner.CODE;
                break;
            case ("??????"):
                banner = Banner.LIFE;
                break;
            case ("??????"):
                banner = Banner.STUDY;
                break;
            default:
                banner = Banner.DEFAULT;
        }

        return banner;
    }

    /**
     * ?????????????????????
     * @param content ???????????????
     * @return ?????????????????????
     */
    private String getOutLine(String content){
        String outline;

        outline = cutContent(content, "<h1>", "</h1>");
        if(!outline.equals(""))  return outline;

        outline = cutContent(content, "<h2>", "</h2>");
        if(!outline.equals("")) return outline;

        outline = cutContent(content, "<h3>", "</h3>");
        if(!outline.equals("")) return outline;

        outline = cutContent(content, "<p>", "</p>");
        if(!outline.equals("")) return outline;

        outline = cutContent(content, "", "???");
        if(!outline.equals("")) return outline;

        return "????????????????????????";
    }

    /**
     * ??????????????????
     * @param content ????????????
     * @param tag1 ???????????? tag1
     * @param tag2 ???????????? tag2
     * @return ??????????????????
     */
    private String cutContent(String content, String tag1, String tag2){
        int begin = content.indexOf(tag1) + tag1.length();
        int end = content.indexOf(tag2);

        return (begin > 0 && end > 0 && end > begin) ? content.substring(begin, end) : "";
    }

    /**
     * ??????????????????????????????
     * ?????????????????????
     * 1. <
     * 2. >
     * 3. #
     * @param content ????????????
     * @return ?????????????????????
     */
    // TODO ???????????????????????????
//    private String filterContent(String content){
//        if(!(content.contains(">") || content.contains("#"))) return content;
//        else{
//            int start, end;
//            if(content.contains(">")){
//                content = content.substring(content.indexOf(">"),
//                        content.indexOf("<", content.indexOf("<") + 1));
//            }
//            if(content.contains("#")){
//                content = content.substring(content.indexOf("#") + 1);
//            }
//        }
//        return filterContent(content);
//    }

}
