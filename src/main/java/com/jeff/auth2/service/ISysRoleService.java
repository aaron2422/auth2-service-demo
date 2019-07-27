package com.jeff.auth2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jeff.auth2.entity.SysRole;

/**
 * <p>
 * 系统角色表 服务类
 * </p>
 *
 * @author jeff
 * @since 2019-07-26
 */
public interface ISysRoleService extends IService<SysRole> {

    String[] getRoleCodeByUserId(String userId);
}
