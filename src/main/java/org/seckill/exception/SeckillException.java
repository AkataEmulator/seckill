package org.seckill.exception;

/**
 * 秒杀业务相关异常
 * Created by 见贤不思齐 on 2017/3/21.
 */
public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
