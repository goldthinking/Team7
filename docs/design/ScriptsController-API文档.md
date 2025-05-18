# ScriptsController API文档

## 接口概览

本文档描述了剧本杀系统中剧本（Scripts）相关的API接口。这些接口用于查询剧本列表和获取剧本详情。

## 基础信息

- **基础路径**：`/Scriptkill/Scripts`
- **内容类型**：`application/json`

## API列表

### 1. 获取剧本列表

#### 接口描述

该接口用于获取剧本列表，支持分页和条件查询。

#### 请求信息

- **URL**：`/Scripts/getScriptsListPage`
- **方法**：`GET`
- **请求参数**：

| 参数名 | 类型 | 必填 | 描述 |
| ------ | ---- | ---- | ---- |
| scriptDiff | String | 否 | 剧本难度 |
| current | Integer | 否 | 当前页码 |
| size | Integer | 否 | 每页记录数 |

#### 响应信息

- **成功响应**：

```json
{
    "code": 0,                     // 状态码，0表示成功
    "data": {                      // 数据对象
        "records": [               // 记录列表
            {
                "scriptId": 1,
                "scriptName": "谜案追凶",
                "scriptDescription": "一个悬疑剧本",
                "scriptAuthor": "张三",
                "scriptDiff": "中等"
            },
            // 更多剧本记录...
        ],
        "total": 10,               // 总记录数
        "size": 10,                // 每页大小
        "current": 1,              // 当前页
        "pages": 1                 // 总页数
    }
}
```

- **错误响应**：

```json
{
    "code": 500,                   // 状态码，非0表示错误
    "msg": "错误信息描述"           // 错误消息
}
```

### 2. 获取剧本详情

#### 接口描述

该接口用于根据剧本ID获取剧本详细信息。

#### 请求信息

- **URL**：`/Scripts/getScriptsInfoById`
- **方法**：`POST`
- **请求体**：

```json
{
    "scriptId": Integer            // 剧本ID（必填）
}
```

#### 响应信息

- **成功响应**：

```json
{
    "code": 0,                     // 状态码，0表示成功
    "data": {                      // 数据对象
        "scriptId": 1,
        "scriptName": "谜案追凶",
        "scriptDescription": "一个悬疑剧本",
        "scriptData": "{...}",      // JSON格式的剧本详细数据
        "scriptAuthor": "张三",
        "scriptDiff": "中等"
    }
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

### Script对象

| 字段名 | 类型 | 描述 |
| ------ | ---- | ---- |
| scriptId | Integer | 剧本唯一标识 |
| scriptName | String | 剧本名称 |
| scriptDescription | String | 剧本描述 |
| scriptData | String | 剧本内容（JSON格式） |
| scriptAuthor | String | 剧本作者 |
| scriptDiff | String | 剧本难度 |

### ScriptDTO对象

继承自CommonDTO，包含以下字段：

| 字段名 | 类型 | 描述 |
| ------ | ---- | ---- |
| scriptId | Integer | 剧本唯一标识 |
| scriptName | String | 剧本名称 |
| scriptDescription | String | 剧本描述 |
| scriptData | String | 剧本内容（JSON格式） |
| scriptAuthor | String | 剧本作者 |
| scriptDiff | String | 剧本难度 |

## 注意事项

1. 获取剧本列表接口使用GET方法，参数通过URL传递
2. 获取剧本详情接口使用POST方法，参数通过请求体JSON传递
3. 响应数据中的data字段包含具体业务数据
4. 分页参数可通过CommonDTO中的字段传递 