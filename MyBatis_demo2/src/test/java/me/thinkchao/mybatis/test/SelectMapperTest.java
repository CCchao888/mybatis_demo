package me.thinkchao.mybatis.test;

import me.thinkchao.mybatis.mapper.SelectMapper;
import me.thinkchao.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Author:chao
 * Date:2023-10-10
 * Description:
 */
public class SelectMapperTest {

    /**
     * MyBatis设置了默认的类型别名
     * 例如：java.lang.Integet---> int,integer
     *       int----> _int,_integer
     *
     *  MyBatis查询返回 一条数据时 可以使用 实体类、list集合、map来接收
     *  MyBatis查询返回 多条数据时 可以使用 实体类的list集合、map的list集合、
     *  或者mapper接口的方法上添加 @MapKey注解 ，此时以某字段为键，
     *  以每条数据转换为map集合作为值，然后放在同一个map集合中 来接收
     */

    @Test
    public void testSelect(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);

        //System.out.println(mapper.getUserById(3));
//        List<User> list = mapper.getAllUser();
//        list.forEach(user -> System.out.println(user));
        //System.out.println(mapper.getAllUser());
        //System.out.println(mapper.getCount());
        //System.out.println(mapper.getUserByIdToMap(3));
        System.out.println(mapper.getAllUserToMap());
    }

}
