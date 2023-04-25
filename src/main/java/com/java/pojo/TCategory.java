package com.java.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 类别
 * </p>
 *
 * @author yoominic
 * @since 2023-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_category")
public class TCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 类别名称
     */
    @TableField("name")
    private String name;

    @TableField("status")
    private Integer status;

    /**
     * 封面
     */
    @TableField("cover_pic")
    private String coverPic;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 标签
     */
    @TableField("label")
    private String label;


}
