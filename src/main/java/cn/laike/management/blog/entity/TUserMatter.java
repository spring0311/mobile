package cn.laike.management.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

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
 * @author sun
 * @since 2020-07-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "TUserMatter对象", description = "")
@KeySequence(value = "T_USER_MATTER_USER_MATTER_ID", clazz = Long.class)
public class TUserMatter implements Serializable {


    private static final long serialVersionUID = 6356231418801586345L;

    @ApiModelProperty(value = "映射表ID")
    @TableId(value = "USER_MATTER_ID", type = IdType.INPUT)
    private Long userMatterId;

    @ApiModelProperty(value = "用户id")
    @TableField("USER_ID")
    private Long userId;

    @ApiModelProperty(value = "事务id")
    @TableField("MATTER_ID")
    private Long matterId;

    @ApiModelProperty(value = "事项对于个人是否重要")
    @TableField("IMPORTANT_ONE")
    private Integer importantOne;

    @ApiModelProperty(value = "事项对于个人是否紧急")
    @TableField("URGENT_ONE")
    private Integer urgentOne;

    @ApiModelProperty(value = "是否完成 0未完成 1完成 默认未完成")
    @TableField("Finish")
    private Integer finish;

    @ApiModelProperty(value = "是否标记 0未标记 1标记 默认未标记")
    @TableField("SIGN")
    private Integer SIGN;

    @ApiModelProperty(value = "完成时间")
    @TableField("ACTUALLY_TIME")
    private Date actuallyTime;

    @ApiModelProperty(value = "是否根据 总提醒时间修改 0是1不是")
    @TableId("IS_REMIND")
    private Integer isRemind;
}
