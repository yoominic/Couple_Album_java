package com.java.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.java.pojo.TContent;
import com.java.response.Result;
import com.java.service.ITContentService;
import com.java.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 相册内容表 前端控制器
 * </p>
 *
 * @author yoominic
 * @since 2023-04-24
 */
@RestController
@RequestMapping("/v1/tContent")
public class TContentController {

    @Autowired
    private ITContentService itContentService;

    @Autowired
    private ITUserService userService;

    @GetMapping("/latest")
    public Object latest() {
        QueryWrapper<TContent> tContentQueryWrapper = new QueryWrapper<>();
        tContentQueryWrapper.eq("status", 1);
        tContentQueryWrapper.orderByDesc("create_time");
        tContentQueryWrapper.last("limit 5");
        List<TContent> tContents = this.itContentService.list(tContentQueryWrapper);
        return Result.success(tContents);
    }

    @GetMapping("/list")
    public Object list() {
        QueryWrapper<TContent> tContentQueryWrapper = new QueryWrapper<>();
        tContentQueryWrapper.eq("status", 1);
        tContentQueryWrapper.orderByDesc("create_time");
        List<TContent> tContents = this.itContentService.list(tContentQueryWrapper);
        tContents.addAll(tContents);
        for (TContent tContent : tContents
        ) {
            tContent.setUser(this.userService.getById(tContent.getUserId()));
        }
        return Result.success(tContents);
    }

}

