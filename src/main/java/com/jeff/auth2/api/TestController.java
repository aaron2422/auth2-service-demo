package com.jeff.auth2.api;

import com.jeff.auth2.entity.SysRole;
import com.jeff.auth2.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author jeff
 * @since 2019-07-26
 */
@RestController
@RequestMapping("/api/")
public class TestController {

    @Autowired
    private ISysRoleService iSysRoleService;

    @GetMapping("user/me")
    public String getMe(Principal principal) {
        return principal == null ? null : principal.getName();
    }

    @GetMapping("role/{id}")
    public SysRole getRole(@PathVariable String id) {
        SysRole role = iSysRoleService.getById(id);
        return role == null ? null : role;
    }
}

