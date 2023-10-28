package me.thinkchao.mybatis.mapper;

import me.thinkchao.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * Author:chao
 * Date:2023-10-11
 * Description:
 */
public interface CaCheMapper {

    Emp getEmpByEid(@Param("eid") Integer eid);

}
