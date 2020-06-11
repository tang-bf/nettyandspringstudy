package nettywebsocket;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

/**
 * @ProjectName: tbhStudy
 * @Package: nettywebsocket
 * @ClassName: MyWebsocketHandler
 * @Description: MyWebsocketHandler
 * @Author: tbf
 * @CreateDate: 2020-05-05 22:43
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-05 22:43
 * @UpdateRemark:
 * @Version: 1.0
 */
//处理文本
public class MyWebsocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("消息内容：" + msg.text());
        ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器时间："+ LocalDateTime.now()));
        ctx.channel().writeAndFlush("test");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("add"+ctx.channel().id().asLongText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("remove"+ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.out.println("发生异常");
        ctx.close();
    }
}
