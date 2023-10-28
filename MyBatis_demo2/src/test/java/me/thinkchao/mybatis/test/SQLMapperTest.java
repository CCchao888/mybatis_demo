package me.thinkchao.mybatis.test;

import me.thinkchao.mybatis.mapper.SQLMapper;
import me.thinkchao.mybatis.pojo.User;
import me.thinkchao.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Author:chao
 * Date:2023-10-10
 * Description:
 */
public class SQLMapperTest {
    @Test
    public  void testSqlMapper(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);

        //System.out.println(mapper.getUserByLike("进"));
        //System.out.println(mapper.deleteMore("18,21"));
        //System.out.println(mapper.getUserByTableName("user"));

        User user = new User(null,"文若和","123",19,"男","123@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
