package com.jessysnow.boot.service.impl;

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
    public void pubANewBlog(String title, String content, int categoryId, HttpServletRequest request) {
        blogMapper.insertANewBlog(title, content, categoryId, SessionUtil.getUserFromSession(request).getId());
    }

    /**
     * 获取文章的概要
     * @param content 文章的正文
     * @return 文章的概要内容
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

        outline = cutContent(content, "", "。");
        if(!outline.equals("")) return outline;

        return "点击博客查看全文";
    }

    /**
     * 截取文章内容
     * @param content 文章内容
     * @param tag1 截取标签 tag1
     * @param tag2 截取标签 tag2
     * @return 截取后的结果
     */
    private String cutContent(String content, String tag1, String tag2){
        int begin = content.indexOf(tag1) + tag1.length();
        int end = content.indexOf(tag2);

        return (begin > 0 && end > 0 && end > begin) ? content.substring(begin, end) : "";
    }

    /**
     * 对经过截取的文章摘要
     * 需要过滤的标签
     * 1. <
     * 2. >
     * 3. #
     * @param content 文章摘要
     * @return 文章的截取结果
     */
    // TODO 对文章摘要进行过滤
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
