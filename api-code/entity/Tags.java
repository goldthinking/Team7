package com.scriptkill.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * TAGS
 * 
 * @author Gyq
 * @version 1.0.0 2025-05-16
 */
@Data
@TableName("tags")
public class Tags implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -5254946167795233692L;

    /** 标签唯一标识 */
    @TableId(value = "tag_id",type = IdType.AUTO)
    private Integer tagId;

    /** 标签名称（例如悬疑、推理） */
    private String tagName;

    /** 标签描述 */
    private String description;

}