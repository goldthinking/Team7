package com.scriptkill.dto;
import com.scriptkill.entity.Gamesession;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * GAMESESSION
 *
 * @author Gyq
 * @version 1.0.0 2025-05-16
 */
@Data
public class GamesessionDTO extends CommonDTO {

    /** 游戏局唯一标识 */
    private Integer gameSessionId;

    /** 游戏开始时间 */
    private Date gameDate;

    /** 游戏状态（进行中、已结束） */
    private String status;

    /** 关联用户（游戏的参与者） */
    private Integer userId;

    /** 关联剧本（游戏的模板） */
    private Integer scriptId;

    /** AI给出的表现评分 */
    private BigDecimal aiScore;

    /** AI文字反馈内容 */
    private String aiFeedback;

    /** 评价时间 */
    private Date ratedAt;

    private List<Gamesession> gamesessionDTOList;

}