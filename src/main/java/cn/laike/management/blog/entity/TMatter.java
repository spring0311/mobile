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
 *
 * </p>
 *
 * @author sun
 * @since 2020-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "TMatter对象", description = "")
@KeySequence(value = "T_MATTER_MATTER_ID", clazz = Long.class)
public class TMatter implements Serializable {


    private static final long serialVersionUID = -483907220346849154L;
    @ApiModelProperty(value = "事务ID")
    @TableId(value = "MATTER_ID", type = IdType.INPUT)
    private Long matterId;

    @ApiModelProperty(value = "事务名称")
    @TableField("MATTER_NAME")
    private String matterName;

    @ApiModelProperty(value = "事务内容")
    @TableField("MATTER_TEXT")
    private String matterText;

    @ApiModelProperty(value = "开始时间")
    @TableField("MATTER_OPEN")
    private Date matterOpen;

    @ApiModelProperty(value = "结束时间")
    @TableField("END")
    private Date end;

    @ApiModelProperty(value = "重要程度  0不重要1重要 默认0")
    @TableField("IMPORTANT")
    private Integer important;

    @ApiModelProperty(value = "是否紧急 0不紧急1紧急  默认0")
    @TableField("URGENT")
    private Integer urgent;

    @ApiModelProperty(value = "事务周期")
    @TableField("PERIOD")
    private String period;

    @ApiModelProperty(value = "部门ID")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "事项是否开启")
    @TableField("IS_OPEN")
    private Integer isOpen;

    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "MODIFY_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    /**
     * 部门名称
     */
    @TableField(exist = false)
    private String deptName;

    /**
     * 用于查询条件的责任人Id
     */
    @TableField(exist = false)
    private Long userId;

    /**
     * 对于个人是否重要
     */
    @TableField(exist = false)
    private Integer importantOne;

    /**
     * 对于个人是否紧急
     */
    @TableField(exist = false)
    private Integer urgentOne;

    /**
     * 提醒时间ID
     */
    @TableField(exist = false)
    private String remindId;

    /**
     * 提醒时间S
     */
    @TableField(exist = false)
    private String remindTime;

    /**
     * 该事项对于个人是否完成
     */
    @TableField(exist = false)
    private Integer finish;

    public Long getId() {
        return matterId;
    }

}
