## **RESTful API**

---

#### 1. 获取所有的剧本（玩家选剧本阶段）

请求路径:  确定资源： /scripts
请求方式： GET
请求参数： （可选）分页page、每页数量size、按类型或难度筛选filter
请求响应：  List<Scprit>Json格式

* ​**200 OK**​：返回剧本列表。
* ​**204 No Content**​：没有剧本。
* ​**500 Internal Server Error**​：服务器错误。
表： Script


#### 2. 获取单个剧本详细内容（玩家选定剧本，开始游戏阶段）

请求路径:  确定资源： /scripts/{scriptid}
请求方式： GET
请求参数： scriptid
请求响应：  剧本id=请求id Scprit Json格式
表 Script 根据ID查询

#### 3. 玩家提交推理结果（游戏结束时）

请求路径：/players/{playerId}/scripts/{scriptId}/results
请求方式：POST
请求参数：playerid+scriptid
请求响应：

新增  GameSession  参数为list
更新  参数为 game_(session_id  ai_, score)  rated_at 时间后端实现

#### 4. 和NPC对话
表： CharacterQuestion 参数为对象