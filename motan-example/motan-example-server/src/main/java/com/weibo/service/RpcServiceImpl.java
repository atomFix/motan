package com.weibo.service;

import com.weibo.api.RpcService;

/**
 * @Description:
 * @author: liukairong1
 * @date: 2023/05/30/16:35
 */
public class RpcServiceImpl implements RpcService {

    @Override
    public String getMessage(String request) {
        return "hi" + " : " + request;
    }
}
