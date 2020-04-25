package com.hthyaq.learnadmin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author ssq
 * @since 2020-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbSubject implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 题目
     */
    private String content;

    /**
     * A选项
     */
    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String optionE;

    private String optionF;

    /**
     * 正确答案
     */
    private String rightOption;
    /**
     * 选项类型
     */
    @TableField(exist = false)
    private String contentTypestr;
    /**
     * 正确答案
     */
    @TableField(exist = false)
    private List rightOptions;

    /**
     * 选项类型
     */
    private Integer contentType;


}
