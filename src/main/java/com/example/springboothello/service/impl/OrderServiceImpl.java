package com.example.springboothello.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboothello.entity.Order;
import com.example.springboothello.entity.Product;
import com.example.springboothello.mapper.OrderMapper;
import com.example.springboothello.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jdk.jfr.Category;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author handsome
 * @since 2020-09-11
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Override
    @Cacheable(cacheNames = "orders", key="'orders '+#page.pages + '-' + #page.size ")
    public IPage<Map<String,Object>> listOrder(Page<Map<String,Object>> page, QueryWrapper wrapper){
        return  this.baseMapper.listOrder(page,wrapper);
    }

    @Override
    public IPage<Map<String,Object>> listCategory(Page<Map<String,Object>> page){
        return  this.baseMapper.listCategory(page);
    }
}
