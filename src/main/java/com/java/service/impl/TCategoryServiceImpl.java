package com.java.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.mapper.TCategoryMapper;
import com.java.pojo.TCategory;
import com.java.service.ITCategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 类别 服务实现类
 * </p>
 *
 * @author yoominic
 * @since 2023-04-24
 */
@Service
public class TCategoryServiceImpl extends ServiceImpl<TCategoryMapper, TCategory> implements ITCategoryService {

}
