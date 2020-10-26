package cn.laike.management.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author sun
 * @since 2020-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "TUser对象", description = "用户表")
@KeySequence(value = "T_USER_USER_ID", clazz = Long.class)
public class TUser implements Serializable {


    private static final long serialVersionUID = 8149970029639664578L;
    @ApiModelProperty(value = "用户ID")
    @TableId(value = "USER_ID", type = IdType.INPUT)
    private Long userId;

    @ApiModelProperty(value = "用户名")
    @TableField("USERNAME")
    private String username;

    @ApiModelProperty(value = "描述")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "密码")
    @TableField("PASSWORD")
    private String password;

    @ApiModelProperty(value = "部门ID")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "用户员工号")
    @TableField("USER_EMPNO")
    private String  userEmpno;

    @ApiModelProperty(value = "职务")
    @TableField("POST")
    private String post;

    @ApiModelProperty(value = "邮箱")
    @TableField("EMAIL")
    private String email;

    @ApiModelProperty(value = "联系电话")
    @TableField("MOBILE")
    private String mobile;

    @ApiModelProperty(value = "状态 0锁定 1有效")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "MODIFY_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    @ApiModelProperty(value = "最近访问时间")
    @TableField("LAST_LOGIN_TIME")
    private Date lastLoginTime;

    @ApiModelProperty(value = "性别 0男 1女 2保密")
    @TableField("SSEX")
    private String ssex;

    @ApiModelProperty(value = "是否开启tab，0关闭 1开启")
    @TableField("IS_TAB")
    private String isTab;

    @ApiModelProperty(value = "主题")
    @TableField("THEME")
    private String theme;

    @ApiModelProperty(value = "头像")
    @TableField("AVATAR")
    private String avatar;

    @TableField(exist = false)
    private String roleIds;

    @TableField(exist = false)
    private String deptName;

}
