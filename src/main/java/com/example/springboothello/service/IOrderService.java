package com.example.springboothello.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboothello.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboothello.entity.Product;
import jdk.jfr.Category;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author handsome
 * @since 2020-09-11
 */
public interface IOrderService extends IService<Order> {
    IPage<Map<String,Object>> listOrder(Page<Map<String,Object>> page, QueryWrapper mapper);
    IPage<Map<String,Object>> listCategory(Page<Map<String,Object>> page);
}
