package me.thinkchao.mybatis.mapper;

import me.thinkchao.mybatis.pojo.User;

import java.util.List;

/**
 * Author:chao
 * Date:2023-10-09
 * Description:
 */
public interface UserMapper {
    /**
     * MyBatis面向接口编程的两个一致：
     * 1、映射文件的namespace要和mapper接口的全类名保持一致
     * 2、映射文件的SQL语句的id要和mapper接口的方法名一致
     *
     * 表--实体类--mapper接口--映射文件
     */



    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();

    /**
     * 查询所有用户信息
     */
    List<User> getAllUser();
}
