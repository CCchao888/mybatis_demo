package me.thinkchao.mybatis.mapper;

import me.thinkchao.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * Author:chao
 * Date:2023-10-10
 * Description:
 */
public interface DeptMapper {

    /**
     * 通过分布查询员工以及员工对应的部门信息
     * 分步查询第二步：通过did查询员工所对应的部门信息
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /**
     * 获取部门以及部门中所有员工的信息
     */
    Dept getDeptAndEmp(@Param("did") Integer did);

    /**
     * 通过分步查询获取部门以及部门中所有员工的信息
     * 分步查询第一步：查询部门信息
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);

}
