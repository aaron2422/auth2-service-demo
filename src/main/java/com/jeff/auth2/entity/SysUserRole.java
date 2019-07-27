package com.jeff.auth2.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author jeff
 * @since 2019-07-26
 */
@Data
@Accessors(chain = true)
public class SysUserRole {

    private static final long serialVersionUID=1L;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;


}
