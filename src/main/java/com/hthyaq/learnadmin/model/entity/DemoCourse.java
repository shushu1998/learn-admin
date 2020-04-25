package com.hthyaq.learnadmin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangqiang
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false,of = {"id"})
@Accessors(chain = true)
public class DemoCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String courseName;

    private Double courseScore;

    private Integer demoId;


}
