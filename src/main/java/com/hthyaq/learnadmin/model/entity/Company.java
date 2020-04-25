package com.hthyaq.learnadmin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author ssq
 * @since 2020-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父级
     */
    private Long pid;

    /**
     * 单位名称
     */
    private String companyName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 排名
     */
    @TableField(exist = false)
    private Integer ranking;
    /**
     * 答对题数
     */
    @TableField(exist = false)
    private Integer answerNum;
    /**
     * 总耗时间
     */
    @TableField(exist = false)
    private Integer answerDuration;


}
