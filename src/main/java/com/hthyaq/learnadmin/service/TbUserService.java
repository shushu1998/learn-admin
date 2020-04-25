package com.hthyaq.learnadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hthyaq.learnadmin.model.dto.UserDTO;
import com.hthyaq.learnadmin.model.entity.TbUser;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author ssq
 * @since 2020-04-23
 */
public interface TbUserService extends IService<TbUser> {


    List<TbUser> pages(Integer currentPage, Integer pageSize, String username, String mobile, String companyName);

    List<UserDTO> pageGroup(Integer currentPage, Integer pageSize, String companyName);
}
