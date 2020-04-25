package com.hthyaq.learnadmin.service.impl;

import com.hthyaq.learnadmin.model.entity.Company;
import com.hthyaq.learnadmin.mapper.CompanyMapper;
import com.hthyaq.learnadmin.service.CompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ssq
 * @since 2020-04-24
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

}
