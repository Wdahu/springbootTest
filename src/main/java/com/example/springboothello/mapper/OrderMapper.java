package com.example.springboothello.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboothello.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboothello.entity.Product;
import jdk.jfr.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author handsome
 * @since 2020-09-11
 */
public interface OrderMapper extends BaseMapper<Order> {

    @Select("SELECT o.id,o.createTime,o.money,o.oderNo,o.`status`,(SELECT p.`name` FROM product p WHERE p.Id=o.productId) as productName,(SELECT u.name FROM `user` u WHERE u.Id=o.uid) as userName FROM _order o ${ew.customSqlSegment}")
    Page<Map<String,Object>> listOrder(Page<?> page,@Param(Constants.WRAPPER) Wrapper wrapper);

    Page<Map<String,Object>> listCategory(Page<?> page);
}
