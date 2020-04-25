package com.hthyaq.learnadmin.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hthyaq.learnadmin.mapper.DemoMapper;
import com.hthyaq.learnadmin.model.entity.Demo;
import com.hthyaq.learnadmin.model.entity.DemoCourse;
import com.hthyaq.learnadmin.model.vo.DemoView;
import com.hthyaq.learnadmin.service.DemoCourseService;
import com.hthyaq.learnadmin.service.DemoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhangqiang
 * @since 2019-08-10
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {
    @Autowired
    DemoCourseService demoCourseService;

    @Override
    public boolean saveData(DemoView demoView) {
        boolean flag1, flag2 = true;

        //demo
        Demo demo = new Demo();

        BeanUtils.copyProperties(demoView, demo);
        //save之后，就有id
        flag1 = this.save(demo);

        //demoCourse
        List<DemoCourse> dataSource = demoView.getCourse().getDataSource();

        if (ObjectUtil.length(dataSource) > 0) {
            //设置demoCourse的demo_id
            int demoId = demo.getId();
            dataSource.forEach(demoCourse -> demoCourse.setDemoId(demoId));
            //保存
            flag2 = demoCourseService.saveBatch(dataSource);
        }


        return flag1 && flag2;
    }

    @Override
    public boolean deleteData(String id) {
        boolean flag1, flag2 = true;

        //demo
        flag1 = this.removeById(id);

        //demoCourse
        QueryWrapper<DemoCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("demo_id", id);
        flag2 = demoCourseService.remove(queryWrapper);

        return flag1 && flag2;
    }

    @Override
    public boolean editData(DemoView demoView) {
        boolean flag1, flag2 = true;

        //demo
        Demo demo = new Demo();
        BeanUtils.copyProperties(demoView, demo);
        flag1 = this.updateById(demo);

        //demoCourse，先删除，后插入
        QueryWrapper<DemoCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("demo_id", demoView.getId());
        flag2 = demoCourseService.remove(queryWrapper);

        List<DemoCourse> dataSource = demoView.getCourse().getDataSource();
        if (ObjectUtil.length(dataSource) > 0) {
            //设置demoCourse的demo_id
            dataSource.forEach(demoCourse -> demoCourse.setDemoId(demo.getId()));
            //保存
            flag2 = demoCourseService.saveBatch(dataSource);
        }

        return flag1 && flag2;
    }
}
