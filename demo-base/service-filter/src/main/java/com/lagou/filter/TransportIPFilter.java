package com.lagou.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

@Activate(group = {CommonConstants.CONSUMER,CommonConstants.PROVIDER})
public class TransportIPFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        RpcContext context =  RpcContext.getContext();
        if (context.isProviderSide()){
            //服务提供者打印
            String clientIp = context.getAttachment("clientIp");
            System.out.println("当前客户端的ip为："+clientIp);

        }else if(context.isConsumerSide()){
            //服务消费者传递
            context.setAttachment("clientIp",context.getRemoteHost());
        }

        // 执行方法
        return  invoker.invoke(invocation);
    }
}
