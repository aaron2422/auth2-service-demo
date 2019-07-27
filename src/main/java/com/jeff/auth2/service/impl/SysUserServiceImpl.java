package com.jeff.auth2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeff.auth2.entity.SysUser;
import com.jeff.auth2.mapper.SysUserMapper;
import com.jeff.auth2.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jeff
 * @since 2019-07-26
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
