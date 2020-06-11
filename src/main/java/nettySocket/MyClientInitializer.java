package nettySocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import nettywechat.MyChatClientHandler;

/**
 * @ProjectName: tbhStudy
 * @Package: nettySocket
 * @ClassName: MyClientInitializer
 * @Description: clientinitializer
 * @Author: tbf
 * @CreateDate: 2020-05-04 16:56
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-04 16:56
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //自定义长度帧解码器
        pipeline.addLast( new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,
                0,4,0,4));
        pipeline.addLast(new LengthFieldPrepender(4));
        pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
        pipeline.addLast(new MyClientHandler());
    }
}
