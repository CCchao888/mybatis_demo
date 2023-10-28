package me.thinkchao.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.thinkchao.mybatis.mapper.EmpMapper;
import me.thinkchao.mybatis.pojo.Emp;
import me.thinkchao.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Author:chao
 * Date:2023-10-12
 * Description:
 */
public class PageHelperTest {

    /**
     * limit index,pageSize
     * index：当前页起始索引
     * pageNum：当前页的页码
     * pageSize：每页显示的条数
     * index=(pageNum-1)*pageSize
     *
     * 使用MyBatis的分页插件实现分页功能
     * 1、在查询功能之前使用PageHelper.startPage(int pageNum, int pageSize)开启分页功能
     * 2、在查询获取list集合之后，使用PageInfo<T> pageInfo = new PageInfo<>(List<T> list, intnavigatePages)获取分页相关数据
     * list：分页之后的数据
     * navigatePages：导航分页的页码数
     */

    @Test
    public void testPageHepler(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        PageHelper.startPage(2,4);
        //System.out.println(mapper.selectByExample(null));
        List<Emp> list = mapper.selectByExample(null);
        PageInfo<Emp> pageInfo = new PageInfo<>(list,5);
        System.out.println(pageInfo);

    }
}
