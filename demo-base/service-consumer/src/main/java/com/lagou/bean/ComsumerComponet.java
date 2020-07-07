package com.lagou.bean;

import com.lagou.service.HelloService;
import com.lagou.service.WorldService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class ComsumerComponet {
    @Reference
    private HelloService  helloService;

    @Reference
    private WorldService worldService;
    public String  sayHello(String name){
        return  helloService.sayHello(name);
    }

    public String  helloWorld(String name){
        return  worldService.helloWorld(name);
    }

}
