package org.seckill.exception;

import org.seckill.dto.SeckillExecution;

/**
 * 重复秒杀异常（运行期异常）
 * Created by 见贤不思齐 on 2017/3/21.
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
