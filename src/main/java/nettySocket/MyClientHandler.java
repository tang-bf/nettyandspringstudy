package nettySocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @ProjectName: tbhStudy
 * @Package: nettySocket
 * @ClassName: MyClientHandler
 * @Description: clienthandler
 * @Author: tbf
 * @CreateDate: 2020-05-04 16:57
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-04 16:57
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyClientHandler  extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
       //tx.channel().writeAndFlush("client output :"+msg);
        ctx.writeAndFlush("from client:"+ LocalDateTime.now());
    }
    //服务端客户端连接上时触发，实现连接后相互执行read0方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active");
        ctx.writeAndFlush("client input :"+"hello server");
        //super.channelActive(ctx);
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
       // super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
