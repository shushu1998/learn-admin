package com.hthyaq.learnadmin.service;

import com.hthyaq.learnadmin.model.entity.Demo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hthyaq.learnadmin.model.vo.DemoView;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhangqiang
 * @since 2019-08-10
 */
public interface DemoService extends IService<Demo> {
    boolean saveData(DemoView demoData);

    boolean deleteData(String id);

    boolean editData(DemoView demoView);
}
