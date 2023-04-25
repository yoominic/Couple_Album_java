package com.java.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.java.pojo.TCategory;
import com.java.response.Result;
import com.java.service.ITCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 类别 前端控制器
 * </p>
 *
 * @author yoominic
 * @since 2023-04-24
 */
@RestController
@RequestMapping("/v1/tCategory")
public class TCategoryController {

    @Autowired
    private ITCategoryService categoryService;

    @GetMapping("list")
    public Object list() {
        QueryWrapper<TCategory> categoryQueryWrapper = new QueryWrapper<>();
        categoryQueryWrapper.eq("status", 1);
        return Result.success(this.categoryService.list(categoryQueryWrapper));
    }
}

