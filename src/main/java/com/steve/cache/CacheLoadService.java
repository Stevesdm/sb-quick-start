package com.steve.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/13 下午6:28
 */
@Service
public class CacheLoadService implements Runnable,InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(CacheLoadService.class);

    @Autowired
    private List<CacheInterface> cacheInterfaceList;

    @Override
    public void run() {

        logger.info("start load cache");
        long start = System.currentTimeMillis();
        if (cacheInterfaceList != null && cacheInterfaceList.size() > 0) {
            for (CacheInterface cacheInterface: cacheInterfaceList) {
                cacheInterface.loadCache();
            }
        }

        long end = System.currentTimeMillis();
        logger.info("load cache finished in {}秒 " ,(end-start)/1000);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Thread t = new Thread(this);
        t.start();
    }
}
