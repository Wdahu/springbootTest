package com.example.springboothello.controller;

//import com.example.springboothello.entity.Product;
//import com.example.springboothello.service.IProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboothello.entity.Order;
import com.example.springboothello.entity.User;
import com.example.springboothello.service.IOrderService;
import com.example.springboothello.service.IProductService;
import com.example.springboothello.service.IUserService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
        import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {
    @Autowired
    IProductService productService;
    @Autowired
    IOrderService orderService;
    @Autowired
    IUserService userService;


    @RequestMapping("/hello")
    @ResponseBody
    public List<Map<String,Object>> index(){
        Page<Map<String,Object>> page=new Page<>(1,5);
        QueryWrapper<Object> queryWrapper=new QueryWrapper<>();
        List<Map<String,Object>> list=orderService.listCategory(page).getRecords();
        return  list;
    }
}
