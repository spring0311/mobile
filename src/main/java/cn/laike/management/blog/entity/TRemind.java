package cn.laike.management.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author weiZiHao
 * @since 2020-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "TRemind对象", description = "")
@KeySequence(value = "T_REMIND_REMIND_ID", clazz = Long.class)
public class TRemind implements Serializable {


    private static final long serialVersionUID = -7092119363734010501L;
    @ApiModelProperty(value = "提醒时间ID")
    @TableId(value = "REMIND_ID", type = IdType.INPUT)
    private Long remindId;

    @ApiModelProperty(value = "提醒时间yyyy-MM-dd")
    @JsonFormat(pattern = "MM-dd", timezone = "GMT+8")
    @TableField("REMIND_TIME")
    private Date remindTime;

    @TableField(exist = false)
    private String remindTimestr;


    @ApiModelProperty(value = "事务Id")
    @TableField("MATTER_ID")
    private Long matterId;
    /**
     * 用于查询条件的责任人Id
     */
   /* @TableField(exist = false)
    private Long userId;*/
    /**
     * 事项名称
     */
    @TableField(exist = false)
    private TMatter tMatter;

    /**
     * 是否激活 0否1是
     */
    @TableId("IS_ACTIVATE")
    private Integer isActivate;

    @TableField("USER_ID")
    private Long userId;

    /**
     * 是否用户创建 是否是个人创建 0不是1是
     */
    @TableId("USER_BY")
    private Integer userBy;


}
