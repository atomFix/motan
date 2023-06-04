package com.weibo.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

public class ClientInboundHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        // 客户端连接建立时发送消息
        String message = "Hello from client!";
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
//        ByteBuf buffer = Unpooled.buffer(messageBytes.length);
        ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeBytes(messageBytes);
        ctx.writeAndFlush(buffer);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // 处理从服务器接收到的消息
        ByteBuf buffer = (ByteBuf) msg;
        byte[] messageBytes = new byte[buffer.readableBytes()];
        buffer.readBytes(messageBytes);
        String message = new String(messageBytes, StandardCharsets.UTF_8);
        System.out.println("Received message from server: " + message);
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}