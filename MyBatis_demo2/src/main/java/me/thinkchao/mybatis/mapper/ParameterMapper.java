package me.thinkchao.mybatis.mapper;

import me.thinkchao.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Author:chao
 * Date:2023-10-09
 * Description: SQL语句获取参数的方法
 */
public interface ParameterMapper {

    int insertUser(User user);

    //使用@Param注解验证登录
    User checkLoginByParam(@Param(value = "username") String username,@Param("password")String password);
    User checkLoginByMap(Map<String,Object> map);
    User checkLogin(String username,String password);

    User getUserByUsername(String username);

    List<User> getAllUser();

}
