package com.jessysnow.boot.service;

import com.jessysnow.boot.entity.Category;

public interface CategoryService {
    /**
     * 检查分类条目是否已经在数据库中存在
     * @param value 分类条目的名称
     * @return 存在 -> true
     *         不存在 -> false
     */
    boolean checkCategoryAlreadyIn(String value);

    /**
     * 新增一条新的分类条目记录
     * @param value 新增条目的名称
     */
    int addANewCategory(String value);

    /**
     * 获取一条分类条目记录
     * @param value 需要获取的分类条目的名称
     * @return 获取到的分类条目的记录
     */
    Category getCategoryByValue(String value);

    /**
     * 通过判断某个类别的名称是否存在决定是新增一条记录
     * 还是从数据库中选择一条已有记录的 id 值
     * @param value 类别名称
     * @return 类别的 id
     */
    int addOrGetCategory(String value);
}
