package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * 配置 spring 和 junit整合，是为了 junit 启动时加载 springIoc容器
 * spring-test,junits
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**告诉junit spring配置文件所在位置*/
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {
    //    注入Dao实现类依赖
    @Resource
    SuccessKilledDao successKilledDao;

    @Test
    public void testInsertSuccessKilled() throws Exception {
        /**
         * 第一次：insertCount=1
         * 第二次：insertCount=0
         * */

        long id = 1001L;
        long phone = 13651076066L;
        int insertCount = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println("insertCount=" + insertCount);
    }

    @Test
    public void testQueryByIdWithSeckill() throws Exception {
        /**
         * SuccessKilled{seckillId=1000, userPhone=13651076066, state=-1, createTime=Tue Mar 21 16:11:05 CST 2017}
         * Seckill{seckillId=1000, name='1000元秒杀iphone6s', number=100, startTime=Sun Mar 20 00:00:00 CST 2016, endTime=Mon Mar 21 00:00:00 CST 2016, createTime=null}
         * */

        long id = 1001L;
        long phone = 13651076066L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }

}