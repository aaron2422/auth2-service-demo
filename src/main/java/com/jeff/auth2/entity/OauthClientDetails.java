package com.jeff.auth2.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * <p>
 * 系统客户端表
 * </p>
 *
 * @author jeff
 * @since 2019-07-26
 */
@Data
@Accessors(chain = true)
public class OauthClientDetails {

    private static final long serialVersionUID=1L;

    @TableId(value = "client_id")
    private String clientId;

    private String resourceIds;

    private String clientSecret;

    private String scope;

    private String authorities;

}
