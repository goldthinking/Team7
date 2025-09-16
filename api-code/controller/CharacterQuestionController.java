package com.scriptkill.controller;

import com.scriptkill.entity.Characterquestion;
import com.scriptkill.service.CharacterQuestionService;
import com.scriptkill.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色问题控制器类
 * 用于处理与角色问题相关的HTTP请求
 */
@RestController
@RequestMapping("/CharacterQuestion")
public class CharacterQuestionController {

    /**
     * 注入角色问题服务
     * 用于处理角色问题的业务逻辑
     */
    @Autowired
    private CharacterQuestionService characterQuestionService;

    /**
     * 插入角色问题信息
     *
     * @param Characterquestion 角色问题对象，包含要插入的问题信息
     * @return 返回结果对象，表示插入操作是否成功
     */
    @PostMapping("/insertCharacterQuestion")
    private Result insertCharacterQuestion(@RequestBody Characterquestion Characterquestion){
        characterQuestionService.inertCharacterQuestion(Characterquestion);
        return Result.ok();
    }
}
