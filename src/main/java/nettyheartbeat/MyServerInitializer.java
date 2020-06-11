package nettyheartbeat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: tbhStudy
 * @Package: nettySocket
 * @ClassName: MyServerInitializer
 * @Description: initializer
 * @Author: tbf
 * @CreateDate: 2020-05-04 16:03
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-04 16:03
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new IdleStateHandler(5,7,10,TimeUnit.SECONDS));
        pipeline.addLast(new MyServerHandler());
    }
}
