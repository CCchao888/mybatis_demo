package me.thinkchao.mybatis.mapper;

import me.thinkchao.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author:chao
 * Date:2023-10-10
 * Description:
 */
public interface SQLMapper {

    /**
     * 根据用户名 模糊查询 用户信息
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * 批量删除
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * 查询指定表中的数据
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    /**
     * 添加用户信息
     */
    void insertUser(User user);

}
