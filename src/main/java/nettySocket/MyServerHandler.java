package nettySocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @ProjectName: tbhStudy
 * @Package: nettySocket
 * @ClassName: MyServderHandler
 * @Description: servetrHandlet
 * @Author: tbf
 * @CreateDate: 2020-05-04 16:36
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-04 16:36
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+","+msg);
        ctx.channel().writeAndFlush("from server :"+ UUID.randomUUID());
        ctx.channel().writeAndFlush("i am server :");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
       // super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
