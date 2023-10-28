package me.thinkchao.mybatis.test;

import me.thinkchao.mybatis.mapper.ParameterMapper;
import me.thinkchao.mybatis.pojo.User;
import me.thinkchao.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Author:chao
 * Date:2023-10-09
 * Description:
 */
public class ParameterMapperTest {

    /**
     * MyBatis获取参数值的两种方式：${} 和 #{}
     * ${}本质是字符串拼接
     * #{}本质是占位符赋值
     *
     * MyBatis获取参数值的各种情况：
     * 1、mapper接口方法的参数为单个字面量类型
     * 可以通过#{}和${}以任意名称获取参数值，但是要注意${}单引号问题
     *
     * 2、mapper接口方法的参数有多个时：
     * 此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     *        以 arg0, arg1...为键 ,以参数为值
     *        以 param1, param2...为键 ,以参数为值
     * 只需通过#{}和${}以键的方式获取参数值，但是要注意${}单引号问题
     *
     * 3、mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中
     * 只需通过#{}和${}以键的方式获取参数值，但是要注意${}单引号问题
     *
     * 4、mapper接口方法的参数是实体类
     * 只需通过#{}和${}以属性名称的方式获取属性值，但是要注意${}单引号问题
     *
     * 5、使用@param注解命名参数，
     * 此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     *           以@Param注解的值为键 ,以参数为值
     *           以 param1, param2...为键 ,以参数为值
     *  只需通过#{}和${}以键的方式获取参数值，但是要注意${}单引号问题
     *
     * 只用4和5就可解决所有
     */

    @Test
    public void testUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);

        //List<User> list = mapper.getAllUser();
        //list.forEach(user -> System.out.println(user));
        //User user = mapper.getUserByUsername("林");

        //User user = mapper.checkLogin("林","123");
        User user = mapper.checkLoginByParam("林","123");
//        Map<String, Object> map = new HashMap<>();
//        map.put("username","林");
//        map.put("password","123");
//        User user = mapper.checkLoginByMap(map);

        //mapper.insertUser(new User(null,"刘德华","123456",63,"男","1234@qq.com"));



        System.out.println(user);
    }
}
