package com.jessysnow.boot.mapper;

import com.jessysnow.boot.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CategoryMapper {

    /**
     * 从数据库筛选出 Category 对象
     * 筛选条件 分类的名称
     * @param value 分类的名称
     * @return Category 对象
     */
    Category selectCategoryByValue(@Param("value")String value);

    /**
     * 向分类表中新添加一条 Category 数据
     * @param category 分类对象
     * @return int 新增分类的 id (自动递增主键)
     */
    void insertANewCategory(Category category);
}
