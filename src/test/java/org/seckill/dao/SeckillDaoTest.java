package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置 spring 和 junit整合，是为了 junit 启动时加载 springIoc容器
 * spring-test,junits
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**告诉junit spring配置文件所在位置*/
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    //    注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;


    @Test
    public void testQueryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
        /*
         * 1000元秒杀iphone6s
         Seckill{seckillId=1000, name='1000元秒杀iphone6s', number=100, startTime=Sun Mar 20 00:00:00 CST 2016, endTime=Mon Mar 21 00:00:00 CST 2016, createTime=Mon Mar 20 17:32:04 CST 2017}
         * */
    }

    @Test
    public void testReduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000L, killTime);
        System.out.println("updateCount=" + updateCount);
        /**
         * Preparing: UPDATE seckill SET number = number - 1 WHERE seckill_id = ? AND start_time <= ? AND end_time >= ? AND number > 0
         * Parameters: 1000(Long), 2017-03-21 16:01:36.61(Timestamp), 2017-03-21 16:01:36.61(Timestamp)
         * Updates: 0
         * */
    }


    @Test
    public void testQueryAll() throws Exception {
        /**
         * org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.binding.BindingException:
         * Parameter 'offset' not found. Available parameters are [0, 1, param1, param2]
         *
         *     List<Seckill> queryAll(int offset, int limit);
         *     java 没有保存形参的记录 queryAll(int offset, int limit) -> queryAll(arg0, arg1)
         *
         * */
        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        for (Seckill s : seckills) {
            System.out.println(s);
        }

        /**
         * Seckill{seckillId=1000, name='1000元秒杀iphone6s', number=100, startTime=Sun Mar 20 00:00:00 CST 2016, endTime=Mon Mar 21 00:00:00 CST 2016, createTime=Mon Mar 20 17:32:04 CST 2017}
         Seckill{seckillId=1001, name='500元秒杀iPad2', number=100, startTime=Sun Mar 20 00:00:00 CST 2016, endTime=Mon Mar 21 00:00:00 CST 2016, createTime=Mon Mar 20 17:32:04 CST 2017}
         Seckill{seckillId=1002, name='300元秒杀小米4', number=100, startTime=Sun Mar 20 00:00:00 CST 2016, endTime=Mon Mar 21 00:00:00 CST 2016, createTime=Mon Mar 20 17:32:04 CST 2017}
         Seckill{seckillId=1003, name='200元秒杀红米note', number=100, startTime=Sun Mar 20 00:00:00 CST 2016, endTime=Mon Mar 21 00:00:00 CST 2016, createTime=Mon Mar 20 17:32:04 CST 2017}
         * */
    }

}