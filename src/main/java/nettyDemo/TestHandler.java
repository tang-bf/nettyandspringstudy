package nettyDemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * @ProjectName: tbhStudy
 * @Package: nettyDemo
 * @ClassName: TestHandler
 * @Description: 自定义handler
 * @Author: tbf
 * @CreateDate: 2020-05-04 14:14
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-04 14:14
 * @UpdateRemark:
 * @Version: 1.0
 */

public class TestHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        System.out.println(msg.getClass());
        System.out.println(ctx.channel().remoteAddress());
        if(msg instanceof  HttpRequest){
            HttpRequest httpRequest = (HttpRequest)msg;
            URI uri = new URI(httpRequest.uri());
            if("/favicon.ico".equals(uri)){
                System.out.println("不做处理");
                return;

            }
            ByteBuf content = Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8);
            FullHttpResponse defaultHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_0,
                    HttpResponseStatus.OK,content);
            defaultHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            defaultHttpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());
            ctx.writeAndFlush(defaultHttpResponse);
            ctx.channel().close();
        }
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel register");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active");
        super.channelActive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel added");
        super.handlerAdded(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel inactive");
        super.channelInactive(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handle unres");
        super.channelUnregistered(ctx);
    }
}
