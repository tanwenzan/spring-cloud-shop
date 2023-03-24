package cn.zeroable.shop.bean.user;

import cn.hutool.crypto.SecureUtil;
import cn.zeroable.shop.utils.id.SnowFlakeFactory;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 简要说明.
 * <br/> 详细说明.
 *
 * @author zeroable
 * @version 2023/3/24 15:18
 * @see
 * @since 0.0.1
 */
@Data
@TableName("cat_user")
@ToString
public class User implements Serializable {
    /**
     * 数据id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @TableField(value = "id", fill = FieldFill.INSERT)
    private Long id;

    /**
     * 用户名
     */
    @TableField("t_username")
    private String username;

    /**
     * 密码
     */
    @TableField("t_password")
    private String password;

    /**
     * 手机号
     */
    @TableField("t_phone")
    private String phone;

    /**
     * 地址
     */
    @TableField("t_address")
    private String address;

    public User(){
        this.id = SnowFlakeFactory.getSnowFlakeFromCache().nextId();
        // 默认密码
        this.password = SecureUtil.md5("123456");
    }

    public static void main(String[] args) {
        User user = new User();
        System.out.println(user);
    }
}