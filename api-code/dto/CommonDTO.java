package com.scriptkill.dto;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
/**
 * 通用数据传输对象类
 * 用于封装分页查询参数，并实现对象到JSON字符串的转换
 */
@Data
public class CommonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;

    public Page getPage(){
        Page page = new Page<>(this.pageNum,this.pageSize);
        return page;
    }

    /**
     * 重写toString方法，将对象转换为JSON字符串
     *
     * @return 对象的JSON字符串表示
     */
    @Override
    public String toString() {
        JSON json = JSONSerializer.toJSON(this);
        return json.toString();
    }

}

