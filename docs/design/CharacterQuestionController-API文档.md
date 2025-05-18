# CharacterQuestionController API文档

## 接口概览

本文档描述了剧本杀系统中角色问题（Character Question）相关的API接口。这些接口用于管理角色在剧本中的问题信息。

## 基础信息

- **基础路径**：`/Scriptkill/CharacterQuestion`
- **内容类型**：`application/json`

## API列表

### 1. 新增角色问题

#### 接口描述

该接口用于向系统中添加新的角色问题信息。

#### 请求信息

- **URL**：`/CharacterQuestion/inertCharacterQuestion`
- **方法**：`PUT`
- **请求体**：

```json
{
    "questionId": Integer,         // 问题ID（可选，系统自动生成）
    "characterId": Integer,        // 角色ID（必填）
    "questionContent": String,     // 问题内容（必填）
    "questionAnswer": String,      // 问题答案（必填）
    "scriptId": Integer            // 关联的剧本ID（必填）
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

### Characterquestion对象

| 字段名 | 类型 | 描述 |
| ------ | ---- | ---- |
| questionId | Integer | 问题的唯一标识符 |
| characterId | Integer | 角色的唯一标识符 |
| questionContent | String | 问题内容 |
| questionAnswer | String | 问题的标准答案 |
| scriptId | Integer | 关联的剧本ID |

## 注意事项

1. 所有请求需要使用JSON格式的请求体
2. 服务器响应也采用JSON格式
3. 接口的URL路径区分大小写
4. 实际接口名称中存在拼写错误："inertCharacterQuestion"，正确拼写应为"insertCharacterQuestion"，但目前系统使用前者 