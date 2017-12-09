package com.steve.base;

import tk.mybatis.mapper.common.*;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;

/**
 * Created by SteveJobson on 2017/7/28.
 */

/**
 * 自定义BaseMapper
 *
 * @param <T>
 */
public interface BaseMapper<T> extends BaseSelectMapper<T>, BaseUpdateMapper<T>, BaseDeleteMapper<T>, ConditionMapper<T>, RowBoundsMapper<T>, MySqlMapper<T> {


}
