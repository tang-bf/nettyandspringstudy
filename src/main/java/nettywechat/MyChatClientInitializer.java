package nettywechat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import nettySocket.MyClientHandler;

/**
 * @ProjectName: tbhStudy
 * @Package: nettywechat
 * @ClassName: MyChatClientInitializer
 * @Description: MyChatClientInitializer
 * @Author: tbf
 * @CreateDate: 2020-05-05 10:34
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-05 10:34
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyChatClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //换行解码器  刚开始由于客户端这里解码器和服务端不一致，导致服务器那边发送的没有接收到,没有调试出来
        pipeline.addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()));
        pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
        pipeline.addLast(new MyChatClientHandler());
    }
}
