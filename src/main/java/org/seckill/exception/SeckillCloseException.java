package org.seckill.exception;

/**
 * 秒杀关闭异常
 * Created by 见贤不思齐 on 2017/3/21.
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
