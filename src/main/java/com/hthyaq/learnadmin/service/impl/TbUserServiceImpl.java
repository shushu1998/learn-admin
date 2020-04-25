package com.hthyaq.learnadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hthyaq.learnadmin.mapper.TbUserMapper;
import com.hthyaq.learnadmin.model.dto.UserDTO;
import com.hthyaq.learnadmin.model.entity.TbUser;
import com.hthyaq.learnadmin.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author ssq
 * @since 2020-04-23
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {
    @Resource
    TbUserMapper tbUserMapper;


    @Override
    public List<TbUser> pages(Integer currentPage, Integer pageSize, String username, String mobile, String companyName) {
        return tbUserMapper.pages(currentPage,pageSize,username,mobile,companyName);
    }

    @Override
    public List<UserDTO> pageGroup(Integer currentPage, Integer pageSize, String companyName) {
        return tbUserMapper.pageGroup(currentPage,pageSize,companyName);
    }


}
