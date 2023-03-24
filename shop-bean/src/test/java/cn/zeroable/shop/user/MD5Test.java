package cn.zeroable.shop.user;


import cn.hutool.crypto.SecureUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 简要说明.
 * <br/> 详细说明.
 *
 * @author zeroable
 * @version 2023/3/24 15:40
 * @see
 * @since 0.0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MD5Test {
    @Test
    public void testMD5() {
        System.out.println(SecureUtil.md5("123456"));
    }
}
