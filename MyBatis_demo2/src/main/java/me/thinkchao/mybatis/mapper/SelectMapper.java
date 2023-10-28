package me.thinkchao.mybatis.mapper;

import me.thinkchao.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Author:chao
 * Date:2023-10-10
 * Description:
 */
public interface SelectMapper {

    User getUserById(@Param("id") Integer id);

    List<User> getAllUser();

    /**
     * 查询用户的总记录数
     */
    Integer getCount();

    /**
     * 根据id查询用户信息为一个map集合
     */
    Map<String,Object> getUserByIdToMap(@Param("id")Integer id);

    /**
     * 查询所有用户信息为一个map集合
     */
    //二者皆可  List<Map<String,Object>> getAllUserToMap();
    @MapKey("id")
    Map<String,Object> getAllUserToMap();

}
