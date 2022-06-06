package com.jessysnow.boot.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BlogMapperTest {

    @Autowired
    private BlogMapper blogMapper;

    @Test
    public void testOnSelectById(){
        System.out.println(blogMapper.selectBlogById(1));
    }

    @Test
    public void selectLastNineBlogWrappers() {
        System.out.println(blogMapper.selectLastNineBlogWrappers());
    }

    @Test
    public void selectBlogWrapperByUserId() {
        System.out.println(blogMapper.selectBlogWrapperByUserId(1));
    }

    @Test
    public void selectBlogWrapperByCategoryName() {
        System.out.println(blogMapper.selectBlogWrapperByCategoryName("科技"));
    }
}
