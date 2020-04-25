package com.hthyaq.learnadmin.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 中英文表名、字段名的映射信息
 * </p>
 *
 * @author zhangqiang
 * @since 2019-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("TableMapInfo_copy")
public class TablemapinfoCopy implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 中文名称
     */
    @TableField("chineseTableName")
    private String chineseTableName;

    @TableField("englishTableName")
    private String englishTableName;

    /**
     * 中文字段名称
     */
    @TableField("chineseColumnName")
    private String chineseColumnName;

    /**
     * 英文字段名称
     */
    @TableField("englishColumnName")
    private String englishColumnName;

    /**
     * java数据类型
     */
    @TableField("dataType")
    private String dataType;


}
