package com.jeff.auth2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeff.auth2.entity.OauthClientDetails;
import com.jeff.auth2.mapper.OauthClientDetailsMapper;
import com.jeff.auth2.service.ISysClientService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统客户端表 服务实现类
 * </p>
 *
 * @author jeff
 * @since 2019-07-26
 */
@Service
public class SysClientServiceImpl extends ServiceImpl<OauthClientDetailsMapper, OauthClientDetails> implements ISysClientService {

}
