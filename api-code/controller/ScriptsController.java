package com.scriptkill.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.scriptkill.dto.ScriptDTO;
import com.scriptkill.entity.Script;
import com.scriptkill.service.CharacterQuestionService;
import com.scriptkill.service.ScriptsService;
import com.scriptkill.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.Map;

/**
 * 剧本列表管理
 */
@RestController
@RequestMapping("/Scripts")
public class ScriptsController {

    @Autowired
    private ScriptsService scriptsService;

    /**
     * 获取剧本列表
     * @param scriptDTO
     * @return
     */
    @GetMapping("/getScriptsListPage")
    public Result getScriptsListPage(@RequestBody ScriptDTO scriptDTO){
        // 根据ScriptDTO查询条件获取Script对象列表，并进行分页
        IPage<Script> page = scriptsService.getScripts(scriptDTO);

        // 创建一个Map对象用于存储查询结果，以便于后续返回给客户端
        Map<String,Object> map = new HashMap<>();

        // 将查询到的分页数据放入Map对象中，键名为"data"
        map.put("data",page) ;

        // 返回成功结果，将包含分页数据的Map对象作为参数传入，封装成Result对象
        return Result.ok(map);
    }

    /**
     * 根据id获取剧本详情
     * @param scriptDTO
     * @return
     **/
    @PostMapping("/getScriptsInfoById")
    public Result getScriptsInfoById(@RequestBody ScriptDTO scriptDTO){
        // 根据ScriptDTO对象获取相应的脚本信息
        Script script = scriptsService.getScriptsInfoById(scriptDTO);

        // 创建一个HashMap用于存储脚本信息
        Map<String,Object> map = new HashMap<>();
        // 将脚本信息以键值对的形式放入Map中，键为"data"
        map.put("data",script) ;

        // 返回包含脚本信息的Map对象
        return Result.ok(map);
    }

}
