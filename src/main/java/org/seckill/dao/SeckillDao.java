package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by 见贤不思齐 on 2017/3/20.
 */
public interface SeckillDao {
    /**
     * 减库存
     *
     * @param seckillId
     * @param killTime
     * @return 如果影响行数 >= 1,表示更新记录行数
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);


    /**
     * 根据 id 查询秒杀对象
     *
     * @param seckillId
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 使用存储过程执行秒杀
     *
     * @param paramMap
     */
    void killByProcedure(Map<String, Object> paramMap);
}
