package com.hthyaq.learnadmin.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class TbUserVo {

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
     * 单位名称
     */
    private String secret;

    /**
     * 答题时间
     */
    private Date answerTime;
    /**
     * 答对数量
     */
    private Integer answerNum;

    /**
     * 答题时长
     */
    private String answerDuration;

}
