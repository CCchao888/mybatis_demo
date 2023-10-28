package me.thinkchao.mybatis.test;

import me.thinkchao.mybatis.mapper.DeptMapper;
import me.thinkchao.mybatis.mapper.EmpMapper;
import me.thinkchao.mybatis.pojo.Emp;
import me.thinkchao.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Author:chao
 * Date:2023-10-10
 * Description:
 */
public class ResultMapTest {

    /**
     * 1、解决字段名和属性名不一致的情况：
     * a> 为字段起别名，保持和属性名一致
     * b> 设置全局配置，将_自动映射为驼峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     * c> 通过resultMap设置自定义的映射关系
     * <resultMap id="empResultMap" type="Emp">
     *         <id property="eid" column="eid"></id>
     *         <result property="empName" column="emp_name"></result>
     *         <result property="age" column="age"></result>
     *         <result property="sex" column="sex"></result>
     *         <result property="email" column="email"></result>
     *     </resultMap>
     *
     * 2、处理多对一的映射关系  （多个员工对同一个部门）
     * a> 级联属性赋值（例如dept.did）
     * <resultMap id="empAndDeptResultMapOne" type="Emp">
     *         <id property="eid" column="eid"></id>
     *         <result property="empName" column="emp_name"></result>
     *         <result property="age" column="age"></result>
     *         <result property="sex" column="sex"></result>
     *         <result property="email" column="email"></result>
     *         <result property="dept.did" column="did"></result>
     *         <result property="dept.deptName" column="dept_name"></result>
     *     </resultMap>
     *b>  association
     * c>  分步查询
     *
     * 3、处理一对多的映射关系  （一个部门对应多个员工）
     * a> collection
     * b> 分步查询
     */

    @Test
    public void testEmpResultMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

//        List<Emp> list = mapper.getAllEmp();
//        list.forEach(emp -> System.out.println(emp));
       // System.out.println(mapper.getEmpAndDept(1));
        //System.out.println(mapper.getEmpAndDeptByStepOne(4));
        Emp emp = mapper.getEmpAndDeptByStepOne(2);
        System.out.println(emp.getEmpName());
    }

    @Test
    public void testDeptResultMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

//        Dept dept = mapper.getDeptAndEmp(1);
//        System.out.println(dept);

        System.out.println(mapper.getDeptAndEmpByStepOne(2));
    }

}
