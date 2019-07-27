package com.jeff.auth2.config;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jeff.auth2.entity.OauthClientDetails;
import com.jeff.auth2.entity.SysUser;
import com.jeff.auth2.service.ISysClientService;
import com.jeff.auth2.service.ISysRoleService;
import com.jeff.auth2.service.ISysUserService;
import com.jeff.auth2.vo.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Jeff on 2019/7/27.
 */
@Slf4j
@Service("dbUserAndClientDetailsService")
public class DbUserAndClientDetailsService implements UserDetailsService, ClientDetailsService {

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private ISysRoleService iSysRoleService;

    @Autowired
    private ISysClientService iSysClientService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        SysUser user = iSysUserService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, s));
        if (user == null) {
            //throw exception inform front end not this user
            throw new UsernameNotFoundException("user + " + s + "not found.");
        }
        String[] roles = iSysRoleService.getRoleCodeByUserId(String.valueOf(user.getUserId()));
        return new AuthUser(user.getUserId(), user.getUsername(), passwordEncoder.encode(user.getPassword()), Arrays.asList(roles));
    }

    @Override
    public ClientDetails loadClientByClientId(String s) throws UsernameNotFoundException {

        BaseClientDetails clientDetail;
        OauthClientDetails client = iSysClientService.getOne(Wrappers.<OauthClientDetails>query().lambda().eq(OauthClientDetails::getClientId, s));
        if (client == null) {
            log.error("Not Find client: {}", client.toString());
            return null;
        }
        clientDetail = new BaseClientDetails();
        clientDetail.setClientId(client.getClientId());
        clientDetail.setClientSecret(passwordEncoder.encode(client.getClientSecret()));
        clientDetail.setScope(new HashSet<>(Arrays.asList(client.getScope().split(","))));
        clientDetail.setResourceIds(new HashSet<>(Arrays.asList(client.getResourceIds().split(","))));
        clientDetail.setAuthorities(AuthorityUtils.createAuthorityList(client.getAuthorities().split(",")));
        clientDetail.setAuthorizedGrantTypes(new HashSet<>(Arrays.asList(new String[]{"password", "refresh_token"})));
        return clientDetail;
    }
}
