package com.scriptkill.controller;

import com.scriptkill.dto.GamesessionDTO;
import com.scriptkill.service.GameSessionService;
import com.scriptkill.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 游戏会话控制器类，用于处理与游戏会话相关的HTTP请求
 */
@RestController
@RequestMapping("/GameSession")
public class GameSessionController {

    /**
     * 注入游戏会话服务，用于处理游戏会话的业务逻辑
     */
    @Autowired
    private GameSessionService gameSessionService;

    /**
     * 保存游戏会话信息
     *
     * @param gamesessionDTO 游戏会话的数据传输对象，包含会话的相关信息
     * @return 返回保存结果，通常是一个表示操作是否成功的消息体
     */
    @PostMapping("/saveGameSession")
    public Result saveGameSession(@RequestBody GamesessionDTO gamesessionDTO) {
        gameSessionService.saveGameSession(gamesessionDTO);
        return Result.ok();
    }

    /**
     * 根据ID更新游戏会话信息
     *
     * @param gamesessionDTO 包含更新后游戏会话信息的数据传输对象，必须包括会话ID
     * @return 返回更新结果，通常是一个表示操作是否成功的消息体
     */
    @PutMapping("/updateGameSessionById")
    public Result updateGameSessionById(@RequestBody GamesessionDTO gamesessionDTO){
        gameSessionService.updateGameSessionById(gamesessionDTO);
        return Result.ok();
    }

}
