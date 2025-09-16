package com.scriptkill.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
/**
 * SCRIPTTAG
 * 
 * @author Gyq
 * @version 1.0.0 2025-05-16
 */
@Data
@TableName("scripttag")
public class Scripttag implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -1002870051822825422L;

    /** scriptTagId */
    @TableId(value = "script_tag_id",type = IdType.AUTO)
    private Integer scriptTagId;

    /** scriptId */
    private Integer scriptId;

    /** tagId */
    private Integer tagId;

}