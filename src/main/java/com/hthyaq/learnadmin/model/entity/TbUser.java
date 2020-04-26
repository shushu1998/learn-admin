package com.hthyaq.learnadmin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author ssq
 * @since 2020-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 姓名
     */
    private String username;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 微信标识
     */
    private String openId;

    /**
     * 单位名称
     */
    private String secret;

    /**
     * 答题时间
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date answerTime;
    /**
     * 答题时间
     */
//    @TableField(exist = false)

//        private String answerTimeStr;

    /**
     * 微信头像
     */
    private String userHead;

    /**
     * 性别
     */
    private String userGender;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 答对数量
     */
    private Integer answerNum;

    /**
     * 答题时长
     */
    private String answerDuration;

    /**
     * 微信昵称
     */
    private String nikeName;

    /**
     * 所在地
     */
    private String uAddress;

    /**
     * 是否推荐  0是不推荐  1是推荐
     */
    private Integer isRecommend;


    /**
     * 名次
     */
    @TableField(exist = false)
    private Integer Ranking;
    /**
     * 答题题数
     */
    @TableField(exist = false)
    private Integer answerNums;
    /**
     * 耗时
     */
    @TableField(exist = false)
    private Integer answerDurations;

}
