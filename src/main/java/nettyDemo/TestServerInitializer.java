package nettyDemo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @ProjectName: tbhStudy
 * @Package: nettyDemo
 * @ClassName: TestServerInitializer
 * @Description: initializer
 * @Author: tbf
 * @CreateDate: 2020-05-04 14:10
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-04 14:10
 * @UpdateRemark:
 * @Version: 1.0
 */

public class TestServerInitializer  extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("mySocketHandler",new HttpServerCodec());
        //添加自定义handler
        ch.pipeline().addLast("myTestHandler",new TestHandler());
    }
}
