package cn.zeroable.shop.utils.exception;

import cn.hutool.core.util.IdUtil;
import cn.zeroable.shop.utils.constant.HttpCode;
import cn.zeroable.shop.utils.resp.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器.
 *
 * @author zeroable
 * @version 2023/3/24 14:25
 * @since 0.0.1
 */
@RestControllerAdvice
@Log4j2
public class RestCtrlExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        log.error("服务器抛出了异常：{}", e);
        return new Result<String>(HttpCode.FAILURE, "执行失败", e.getMessage());
    }
}
