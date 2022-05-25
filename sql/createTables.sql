/*
* 数据库建表文件 -- 未进行索引优化
* 列名规则：单个单词 -- 全小写
* 	    多个单词 -- 第一个单词首字母小写，
*			其他单词的首字母大写
*/

CREATE DATABASE blogsys;
USE blogsys;

/* 用户表 */
CREATE TABLE `user`(
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       username VARCHAR(50) UNIQUE,
                       `password` VARCHAR(50),
                       is_admin BOOLEAN DEFAULT FALSE,
                       avatar VARCHAR(100) DEFAULT '/photos/violet_evergarden.jpg',
                       `desc` VARCHAR(200) DEFAULT NULL
);

/* 类别表 */
CREATE TABLE category(
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         value VARCHAR(30)
);

/* 博客表 */
CREATE TABLE blog(
                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                     title VARCHAR(50),
                     content TEXT,
                     pub_date DATETIME,
                     category_id INT,
                     user_id BIGINT,
                     `count` BIGINT DEFAULT 0,
                     FOREIGN KEY(category_id) REFERENCES category(id),
                     FOREIGN KEY(user_id) REFERENCES `user`(id)
);

/* 评论表 */
CREATE TABLE `comment`(
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          blog_id BIGINT,
                          user_id BIGINT,
                          content VARCHAR(200),
                          pub_date DATETIME,
                          FOREIGN KEY(blog_id) REFERENCES blog(id),
                          FOREIGN KEY(user_id) REFERENCES `user`(id)
);

/* 点赞表 */
CREATE TABLE `like`(
                       user_id BIGINT,
                       blog_id BIGINT,
                       PRIMARY KEY(user_id, blog_id),
                       FOREIGN KEY(user_id) REFERENCES user(id),
                       FOREIGN KEY(blog_id) REFERENCES blog(id)
);

/* 点踩表 */
CREATE TABLE `unlike`(
                         user_id BIGINT,
                         blog_id BIGINT,
                         PRIMARY KEY(user_id, blog_id),
                         FOREIGN KEY(user_id) REFERENCES user(id),
                         FOREIGN KEY(blog_id) REFERENCES blog(id)
);

/*
 * 索引 :  1. mysql 提供的主键索引
 *        2. `user` 表的 username 列创建的 unique 索引
 *        3. `like` / `unlike` 使用 user_id, blog_id 作为联合主键索引
 */