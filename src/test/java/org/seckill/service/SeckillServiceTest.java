package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 见贤不思齐 on 2017/3/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class SeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @Test
    public void testGetSeckillList() throws Exception {
        List<Seckill> seckills = seckillService.getSeckillList();
        logger.info("list={}", seckills);
    }

    @Test
    public void testGetById() throws Exception {
        long id = 1000L;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}", seckill);

    }

  /*  @Test
    public void testExportSeckillUrl() throws Exception {
        long id = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}", exposer);


        *//**
     * exposer=Exposer{exposed=true, md5='3fd3dcd7bb3f44197430a193c189ea08', seckillId=1000, now=0, start=0, end=0}
     * *//*
    }

    @Test
    public void testExecuteSeckill() throws Exception {
        long id = 1000L;
        long phone = 13651076064L;
        String md5 = "3fd3dcd7bb3f44197430a193c189ea08";
        SeckillExecution execution = null;
        try {
            execution = seckillService.executeSeckill(id, phone, md5);
            logger.info("result={}", execution);
        } catch (RepeatKillException e1) {
            logger.error(e1.getMessage());
        } catch (SeckillCloseException e2) {
            logger.error(e2.getMessage());
        }

        */

    /**
     * result=SeckillExecution{seckillId=1000, state=1, stateInfo='秒杀成功',
     * successKilled=SuccessKilled{seckillId=1000, userPhone=13651076064, state=0, createTime=Tue Mar 21 23:28:06 CST 2017}}
     *//*
    }
*/
    //测试代码完整逻辑，注意可以重复执行
    @Test
    public void testExportSeckilLogic() throws Exception {
        long id = 1001L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer={}", exposer);
            long phone = 13651076064L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
                logger.info("result={}", execution);
            } catch (RepeatKillException e1) {
                logger.error(e1.getMessage());
            } catch (SeckillCloseException e2) {
                logger.error(e2.getMessage());
            }
        } else {
            //秒杀未开启
            logger.warn("exposer={}", exposer);
        }
    }

    @Test
    public void executeSeckillProcedure() {
        long seckillId = 1001;
        long phone = 18795878261L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
            logger.info(execution.getStateInfo());
        }
    }

}