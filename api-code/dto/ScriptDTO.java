package com.scriptkill.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * SCRIPT
 *
 * @author Gyq
 * @version 1.0.0 2025-05-16
 */
@Data
public class ScriptDTO extends CommonDTO{

    /**
     * 剧本唯一标识
     */
    private Integer scriptId;

    /**
     * 剧本名称
     */
    private String scriptName;

    /**
     * 剧本描述
     */
    private String scriptDescription;

    /**
     * 剧本内容（JSON格式，存储剧本详细信息）
     */
    private String scriptData;

    /**
     * 剧本作者
     */
    private String scriptAuthor;

    /**
     * 剧本难度
     */
    private String scriptDiff;

}