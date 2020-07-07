package com.lagou.service.impl;

import com.lagou.service.HelloService;
import com.lagou.service.WorldService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class WorldServiceImpl   implements WorldService {
    @Override
    public String helloWorld(String name) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "world:"+name;
    }
}
