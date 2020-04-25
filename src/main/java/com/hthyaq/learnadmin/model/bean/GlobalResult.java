package com.hthyaq.learnadmin.model.bean;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hthyaq.learnadmin.common.constants.GlobalConstants;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@SuppressWarnings("unchecked")
public class GlobalResult {
    /**
     * 标志位，true-成功、false-失败
     */
    private Boolean flag;
    private Integer code;
    private String msg;
    private Object data;

    public static GlobalResult success() {
        return new GlobalResult()
                .setFlag(GlobalConstants.TRUE)
                .setCode(GlobalConstants.SUCCESS)
                .setMsg(GlobalConstants.SUCCESS_MSG);
    }

    public static GlobalResult success(String msg) {
        return success().setMsg(msg);
    }


    public static <T> GlobalResult success(Object data) {
        GlobalResult globalResult = GlobalResult.success();
        if (data instanceof IPage) {
            IPage<T> page = (IPage<T>) data;
            int pageSize = (int) page.getSize();
            int total = (int) page.getTotal();
            //计算总页数
            int totalPage = total / pageSize + ((total % pageSize == 0) ? 0 : 1);
            PageData<T> pageData = new PageData<>((int) page.getCurrent(), pageSize, total, totalPage, page.getRecords());
            return globalResult.setData(pageData);
        } else if (data instanceof Boolean) {
            return ((boolean) data) ? GlobalResult.success() : GlobalResult.fail();
        } else {
            return globalResult.setData(data);
        }
    }

    public static GlobalResult success(String msg, Object data) {
        return success(data).setMsg(msg);
    }

    public static GlobalResult fail() {
        return new GlobalResult()
                .setFlag(GlobalConstants.FALSE)
                .setCode(GlobalConstants.FAIL)
                .setMsg(GlobalConstants.FAIL_MSG);
    }

    public static GlobalResult fail(String msg) {
        return fail().setMsg(msg);
    }

}