package me.thinkchao.mybatis;

import me.thinkchao.mybatis.mapper.EmpMapper;
import me.thinkchao.mybatis.pojo.EmpExample;
import me.thinkchao.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Author:chao
 * Date:2023-10-12
 * Description:
 */
public class MBGTest {
    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        //查询所有数据
        //System.out.println(mapper.selectByExample(null));
        //根据条件查询
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameEqualTo("张三").andAgeBetween(18,29);
        empExample.or().andDidIsNotNull();
        System.out.println(mapper.selectByExample(empExample));


    }
}








