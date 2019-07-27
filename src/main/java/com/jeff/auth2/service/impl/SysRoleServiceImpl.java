package com.jeff.auth2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeff.auth2.entity.SysRole;
import com.jeff.auth2.mapper.SysRoleMapper;
import com.jeff.auth2.service.ISysRoleService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author jeff
 * @since 2019-07-26
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Resource
    public SysRoleMapper sysRoleMapper;

    @Override
    public String[] getRoleCodeByUserId(String userId) {
        return sysRoleMapper.getRoleCodeByUserId(userId);
    }
}
