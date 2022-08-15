package com.demo.domain;

import com.advance.sunrise.tool.datamask.annotation.SensitiveInfo;
import com.advance.sunrise.tool.datamask.constant.MaskModeEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wanghl
 * @date 2022/7/25
 */
@Data
@TableName("t_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    @SensitiveInfo(handler = com.demo.handler.PhoneMaskHandler.class)
    private String phone;
    @SensitiveInfo
    private String password;
}
