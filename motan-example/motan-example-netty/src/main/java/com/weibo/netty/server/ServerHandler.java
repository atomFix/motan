package com.weibo.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf message = (ByteBuf) msg;
        System.out.println("Received message from client: " + message.toString(StandardCharsets.UTF_8));
        // 在这里可以编写处理消息的逻辑
        // 假设服务器收到消息后回复客户端
        String response = "Hello from server!";
        ctx.writeAndFlush(ctx.alloc().buffer().writeBytes(response.getBytes(StandardCharsets.UTF_8)));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}