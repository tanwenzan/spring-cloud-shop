package cn.zeroable.shop.utils.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 简要说明.
 * <br/> 详细说明.
 *
 * @author zeroable
 * @version 2023/3/24 14:27
 * @see
 * @since 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态描述
     */
    private String codeMsg;

    /**
     *  返回的数据
     */
    private T data;
}
