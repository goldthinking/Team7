package com.scriptkill.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.sql.Date;

/**
 * USER
 * 
 * @author Gyq
 * @version 1.0.0 2025-05-16
 */
@Data
@TableName("user")
public class User implements Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 203323389316725924L;

    /** 用户唯一标识 */
    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer userId;

    /** 用户的微信号（与微信号绑定） */
    private String wechatId;

    /** 用户昵称 */
    private String username;

    /** 用户头像 */
    private String profilePicture;

    /** 用户注册时间 */
    private Date createTime;

    /** 最后一次登录时间 */
    private Date lastLoginTime;

}