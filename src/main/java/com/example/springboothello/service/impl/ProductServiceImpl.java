package com.example.springboothello.service.impl;

import com.example.springboothello.entity.Product;
import com.example.springboothello.mapper.ProductMapper;
import com.example.springboothello.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author handsome
 * @since 2020-09-10
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
