package com.scriptkill.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * GAMESESSION
 *
 * @author Gyq
 * @version 1.0.0 2025-05-16
 */
@Data
@TableName("gamesession")
public class Gamesession implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = -4588289686682478955L;


    /**
     * 游戏局唯一标识
     */
    @TableId(value = "game_session_id",type = IdType.AUTO)
    private int gameSessionId;

    /**
     * 游戏开始时间
     */
    private Date gameDate;

    /**
     * 游戏状态（进行中、已结束）
     */
    private String status;

    /**
     * 关联用户（游戏的参与者）
     */
    private Integer userId;

    /**
     * 关联剧本（游戏的模板）
     */
    private Integer scriptId;

    /**
     * AI给出的表现评分
     */
    private BigDecimal aiScore;

    /**
     * AI文字反馈内容
     */
    private String aiFeedback;

    /**
     * 评价时间
     */
    private Date ratedAt;

}