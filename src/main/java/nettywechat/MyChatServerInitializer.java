package nettywechat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import nettySocket.MyServerHandler;

/**
 * @ProjectName: tbhStudy
 * @Package: nettywechat
 * @ClassName: MyChatServerInitializer
 * @Description: initializer
 * @Author: tbf
 * @CreateDate: 2020-05-05 0:02
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-05 0:02
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyChatServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline1 = ch.pipeline();
        pipeline1.addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()));

        pipeline1.addLast(new StringDecoder(CharsetUtil.UTF_8));
        pipeline1.addLast(new StringEncoder(CharsetUtil.UTF_8));
        pipeline1.addLast(new MyChatServerHandler());
    }
}
