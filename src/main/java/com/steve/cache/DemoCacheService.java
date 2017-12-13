package com.steve.cache;

import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/13 下午6:31
 */
@Service
public class DemoCacheService implements CacheInterface{
    @Override
    public boolean loadCache() {
        System.out.println("11");
        return true;
    }

    @Override
    public boolean deleteCache() {
        return false;
    }
}
