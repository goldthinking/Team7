package com.scriptkill.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * CHARACTERQUESTION
 *
 * @author Gyq
 * @version 1.0.0 2025-05-16
 */
@Data
@TableName("characterquestion")
public class Characterquestion implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 8509266275573205796L;


    /**
     * 提问唯一标识
     */
    @TableId(value = "question_id", type = IdType.AUTO)
    private Integer questionId;

    /**
     * 虚拟角色名称（非实体表）
     */
    private String characterName;

    /**
     * 关联对局
     */
    private Integer gameSessionId;

    /**
     * 提问内容
     */
    private String questionText;

    /**
     * 角色回答内容（含胡编但有正确信息）
     */
    private String answerText;

    /**
     * 提问时间
     */
    private Date createdAt;

}