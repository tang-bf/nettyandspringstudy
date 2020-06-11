package nettyheartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.EventListener;
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

public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent =  (IdleStateEvent) evt;
           String eventType = null;
           switch (idleStateEvent.state()){
               case ALL_IDLE:
                   eventType ="读写空闲";
                   break;
               case READER_IDLE:
                   eventType="读空闲";
                   break;
               case WRITER_IDLE:
                   eventType ="写空闲";
                   break;
           }
            System.out.println(ctx.channel().remoteAddress() +"超时事件:"+ eventType);
           ctx.channel().close();
        }
    }
}
