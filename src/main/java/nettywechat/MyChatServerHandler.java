package nettywechat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.List;

/**
 * @ProjectName: tbhStudy
 * @Package: nettywechat
 * @ClassName: MyChatServerHandler
 * @Description: handler
 * @Author: tbf
 * @CreateDate: 2020-05-05 9:46
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-05 9:46
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {
    private  static ChannelGroup groups = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("////////");
        groups.forEach(ch -> {
            System.out.println(groups.size()+"now ");
                    if(channel != ch){
                        System.out.println("不是自己");
                        ch.writeAndFlush(channel.remoteAddress()+"发送的消息" +msg +"\n");
                        //ch.writeAndFlush("xxxxxxxx \n");
                      //  channel.writeAndFlush(channel.remoteAddress()+"发送的消息" +msg +"\n");
                    }else{
                        System.out.println("是自己");
                        ch.writeAndFlush("自己发送的消息" +msg +"\n");
                       // ch.writeAndFlush("yyyyyy \n");
                       // channel.writeAndFlush(channel.remoteAddress()+"发送的消息" +msg +"\n");
                    }
                }
        );
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//        super.handlerAdded(ctx);
        Channel channel = ctx.channel();
        /**
         * Writes the specified {@code message} to all {@link Channel}s in this
         * group. If the specified {@code message} is an instance of
         * {@link ByteBuf}, it is automatically
         * {@linkplain ByteBuf#duplicate() duplicated} to avoid a race
         * condition. The same is true for {@link ByteBufHolder}. Please note that this operation is asynchronous as
         * {@link Channel#write(Object)} is.
         *
         * @return itself
         */
        System.out.println(">>>>>>>");
        groups.writeAndFlush("[服务器]"+channel.remoteAddress()+"加入\n");
        groups.add(channel);
        System.out.println("<<<<<<<");

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
//        super.handlerRemoved(ctx);
        Channel channel = ctx.channel();
        groups.writeAndFlush("[服务器]"+channel.remoteAddress()+"离开\n");
       // groups.remove(channel);//次行代码会自定调用   netty ，不需要写这个方法
        System.out.println(groups.size()+"now remove");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        super.channelInactive(ctx);
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress()+"下线");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress()+"上线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
