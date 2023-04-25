package com.java.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.mapper.TContentMapper;
import com.java.pojo.TContent;
import com.java.service.ITContentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 相册内容表 服务实现类
 * </p>
 *
 * @author yoominic
 * @since 2023-04-24
 */
@Service
public class TContentServiceImpl extends ServiceImpl<TContentMapper, TContent> implements ITContentService {

}
