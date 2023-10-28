package me.thinkchao.mybatis.test;

import me.thinkchao.mybatis.mapper.UserMapper;
import me.thinkchao.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author:chao
 * Date:2023-10-09
 * Description:
 */
public class MyBatisTest {
    /**
     * SqlSession默认不自动提交事务
     * sqlSessionFactory.openSession(true) 可开启自动提交
     * @throws IOException
     */
    @Test
    public void testMyBatis() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //测试功能
        //int result = mapper.insertUser();
        //mapper.updateUser();
        //mapper.deleteUser();
        //User user = mapper.getUserById();
        //System.out.println(user);

        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
        //提交事务
        //sqlSession.commit();
        //System.out.println("影响行数："+result);
    }

}
