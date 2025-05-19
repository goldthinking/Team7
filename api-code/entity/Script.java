package com.scriptkill.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * SCRIPT
 * 
 * @author Gyq
 * @version 1.0.0 2025-05-16
 */
@Data
@TableName("script")
public class Script implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -9212396539093588406L;

    /** 剧本唯一标识 */
    @TableId(value = "script_id",type = IdType.AUTO)
    private Integer scriptId;

    /** 剧本名称 */
    private String scriptName;

    /** 剧本描述 */
    private String scriptDescription;

    /** 剧本内容（JSON格式，存储剧本详细信息） */
    private String scriptData;

    /** 剧本作者 */
    private String scriptAuthor;

    /** 剧本难度 */
    private String scriptDiff;

}