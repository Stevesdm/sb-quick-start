package com.steve.mock;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2018/1/25 下午2:07
 */
public class MockDemo {

    @Test
    public void demo(){
        List mockedList= mock(List.class);
        when(mockedList.get(10)).thenReturn("10");

        Assert.assertEquals("数据不相等","110",mockedList.get(10));
    }

}
