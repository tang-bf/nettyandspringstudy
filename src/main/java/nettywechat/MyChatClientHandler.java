package nettywechat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * @ProjectName: tbhStudy
 * @Package: nettywechat
 * @ClassName: MyChatClientHandler
 * @Description: MyChatClientHandler
 * @Author: tbf
 * @CreateDate: 2020-05-05 10:35
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-05 10:35
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyChatClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
//        System.out.println(ctx.channel().remoteAddress());
//        //tx.channel().writeAndFlush("client output :"+msg);
//        ctx.writeAndFlush("from client:"+ LocalDateTime.now());
        System.out.println(msg);
    }
}
