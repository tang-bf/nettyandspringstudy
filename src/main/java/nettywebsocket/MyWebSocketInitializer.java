package nettywebsocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @ProjectName: tbhStudy
 * @Package: nettywebsocket
 * @ClassName: MyWebSocketInitializer
 * @Description: WebSocketInitializer
 * @Author: tbf
 * @CreateDate: 2020-05-05 22:33
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-05 22:33
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyWebSocketInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new ChunkedWriteHandler());
        pipeline.addLast(new HttpObjectAggregator(8192));
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        pipeline.addLast(new MyWebsocketHandler());
    }
}
