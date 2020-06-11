package nettySocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

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
        ChannelPipeline pipeline1 = ch.pipeline();
        //自定义长度帧解码器
        pipeline1.addLast( new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,
                0,  4,0,4));
        pipeline1.addLast(new LengthFieldPrepender(4));
        pipeline1.addLast(new StringDecoder(CharsetUtil.UTF_8));
        pipeline1.addLast(new StringEncoder(CharsetUtil.UTF_8));
        pipeline1.addLast(new MyServerHandler());
    }
}
