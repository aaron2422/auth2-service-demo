package com.jeff.auth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeff.auth2.entity.SysRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 系统角色表 Mapper 接口
 * </p>
 *
 * @author jeff
 * @since 2019-07-26
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    String[] getRoleCodeByUserId(@Param("userId") String userId);

}
