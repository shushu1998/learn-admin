package com.hthyaq.learnadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hthyaq.learnadmin.model.dto.UserDTO;
import com.hthyaq.learnadmin.model.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author ssq
 * @since 2020-04-23
 */
@Mapper
public interface TbUserMapper extends BaseMapper<TbUser> {


    List<TbUser> pages(Integer currentPage, Integer pageSize, String username, String mobile, String companyName);

    List<UserDTO> pageGroup(Integer currentPage, Integer pageSize, String companyName);

    List<UserDTO> listGlobal(String companyName);

    List<TbUser> personalList(String username, String mobile, String secret);

    List<UserDTO> countGroup(String companyName);

    List<TbUser> countpages(String username, String mobile, String companyName);
}
