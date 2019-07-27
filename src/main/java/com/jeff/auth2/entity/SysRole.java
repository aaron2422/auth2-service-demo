package com.jeff.auth2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统角色表
 * </p>
 *
 * @author jeff
 * @since 2019-07-26
 */
@Data
@Accessors(chain = true)
public class SysRole {

    private static final long serialVersionUID=1L;

    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    private String roleName;

    private String roleCode;

    private String roleDesc;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 删除标识（0-正常,1-删除）
     */
    private String delFlag;

    private Integer tenantId;


}
