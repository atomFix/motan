package com.weibo.controller;

import com.weibo.api.RpcService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @author: liukairong1
 * @date: 2023/05/30/17:30
 */
@RestController
@RequestMapping("/rpc")
public class RpcController {

    @Resource
    private RpcService rpcService;


    @RequestMapping("/message")
    public String message(String message) {
        return rpcService.getMessage(message);
    }

}
