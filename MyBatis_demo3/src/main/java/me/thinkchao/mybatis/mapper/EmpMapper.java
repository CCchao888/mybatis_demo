package me.thinkchao.mybatis.mapper;

import me.thinkchao.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author:chao
 * Date:2023-10-10
 * Description:
 */
public interface EmpMapper {

    List<Emp> getAllEmp();

    /**
     * 查询员工以及员工对应的部门信息
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 通过分布查询员工以及员工对应的部门信息
     * 分步查询第一步：查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    /**
     * 通过分步查询获取部门以及部门中所有员工的信息
     * 分步查询第二步：根据did查询员工信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);

}
