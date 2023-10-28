package me.thinkchao.mybatis.test;

import me.thinkchao.mybatis.mapper.DynamicSQLMapper;
import me.thinkchao.mybatis.pojo.Emp;
import me.thinkchao.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Author:chao
 * Date:2023-10-11
 * Description:
 */
public class DynamicSQLMapperTest {

    /**
     * 动态SQL:
     * 1、if：根据标签中test属性对应的表达式决定标签中的内容是否需要拼接到SQL中   注意:最好在where后面写个恒等式（例如1=1）
     * 2、where：
     *  当where标签中有内容，会自动生成where关键字，且会自动去掉内容前多余的and或or
     *  当where标签中没有内容，where标签没有任何效果
     *  注意：where标签不能自动去掉内容后多余的and或or
     *  3、trim:
     *  若标签中有内容时：
     *  prefix/suffix: 将trim标签中内容前面或后面添加指定内容
     *  suffixOverrides/prefixOverrides:将trim标签中内容前面或后面去掉指定内容
     *  当trim标签中没有内容，trim标签没有任何效果
     *  4、choose、when、otherwise，相当于 if...else if...else
     *  5、foreach
     *  collection: 设置需要循环的数组或集合
     *  item：表示数组或集合中的每一个数据
     *  separator：表示循环体之间的分隔符
     *  open：foreach标签所循环的所有内容的开始符
     *  close：foreach标签所循环的所有内容的结束符
     *  6、sql标签
     *  设置sql片段：<sql id="empColumns">eid,emp_name,age,sex,email</sql>
     *  引用sql片段：select <include refid="empColumns"></include> from emp
     */

    @Test
    public void testDynamicSQLMapper(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);

        List<Emp> list = mapper.getEmpByCondition(new Emp(null,"赵五",22,"女","123@163.com"));
        System.out.println(list);

        //System.out.println(mapper.getEmpByChoose(new Emp(null,"田七",null,null,null)));
        //System.out.println(mapper.deleteMoreByArray(new Integer[]{14}));

//        Emp emp1 = new Emp(null,"a",23,"男","66@qq.com");
//        Emp emp2 = new Emp(null,"a",23,"男","66@qq.com");
//        Emp emp3 = new Emp(null,"a",23,"男","66@qq.com");
//        List<Emp> emps = Arrays.asList(emp1,emp2,emp3);
//        mapper.insertMoreByList(emps);


    }
}
