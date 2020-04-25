package com.hthyaq.learnadmin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 错误统计
 * </p>
 *
 * @author ssq
 * @since 2020-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbSubjectError implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 题目ID
     */
    private Integer subjectId;

    /**
     * 题目名称
     */
    private String subjectName;

    /**
     * 错误率
     */
    private Double errorRate;

    private Integer startAge;

    private Integer endAge;

    private Integer subjectType;


}
