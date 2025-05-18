# GameSessionController API文档

## 接口概览

本文档描述了剧本杀系统中游戏会话（Game Session）相关的API接口。这些接口用于管理游戏会话的创建和更新。

## 基础信息

- **基础路径**：`/Scriptkill/GameSession`
- **内容类型**：`application/json`

## API列表

### 1. 保存游戏会话

#### 接口描述

该接口用于创建新的游戏会话信息。

#### 请求信息

- **URL**：`/GameSession/saveGameSession`
- **方法**：`POST`
- **请求体**：

```json
{
    "sessionId": Integer,          // 会话ID（可选，系统自动生成）
    "scriptId": Integer,           // 关联剧本ID（必填）
    "userId": Integer,             // 用户ID（必填）
    "startTime": Date,             // 开始时间
    "endTime": Date,               // 结束时间
    "sessionStatus": String,       // 会话状态
    "sessionData": String          // 会话数据（JSON格式）
}
```

#### 响应信息

- **成功响应**：

```json
{
    "code": 0,                     // 状态码，0表示成功
    "msg": "操作成功"               // 响应消息
}
```

- **错误响应**：

```json
{
    "code": 500,                   // 状态码，非0表示错误
    "msg": "错误信息描述"           // 错误消息
}
```

### 2. 更新游戏会话

#### 接口描述

该接口用于更新已有的游戏会话信息。

#### 请求信息

- **URL**：`/GameSession/updateGameSessionById`
- **方法**：`PUT`
- **请求体**：

```json
{
    "sessionId": Integer,          // 会话ID（必填）
    "scriptId": Integer,           // 关联剧本ID
    "userId": Integer,             // 用户ID
    "startTime": Date,             // 开始时间
    "endTime": Date,               // 结束时间
    "sessionStatus": String,       // 会话状态
    "sessionData": String          // 会话数据（JSON格式）
}
```

#### 响应信息

- **成功响应**：

```json
{
    "code": 0,                     // 状态码，0表示成功
    "msg": "操作成功"               // 响应消息
}
```

- **错误响应**：

```json
{
    "code": 500,                   // 状态码，非0表示错误
    "msg": "错误信息描述"           // 错误消息
}
```

## 数据结构

### GamesessionDTO对象

| 字段名 | 类型 | 描述 |
| ------ | ---- | ---- |
| sessionId | Integer | 会话的唯一标识符 |
| scriptId | Integer | 关联的剧本ID |
| userId | Integer | 用户ID |
| startTime | Date | 会话开始时间 |
| endTime | Date | 会话结束时间 |
| sessionStatus | String | 会话状态 |
| sessionData | String | 会话数据（JSON格式） |

## 注意事项

1. 所有请求需要使用JSON格式的请求体
2. 服务器响应采用JSON格式
3. 更新会话时必须提供sessionId
4. 响应代码0表示操作成功，非0表示操作失败 