package nettySocket;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ProjectName: tbhStudy
 * @Package: nettySocket
 * @ClassName: MyClient
 * @Description: 客户端, 只需要一个循环组
 * @Author: tbf
 * @CreateDate: 2020-05-04 16:45
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-04 16:45
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyClient {
    public static void main(String[] args) throws  Exception{
        EventLoopGroup loopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(loopGroup).channel(NioSocketChannel.class)
                    .handler(new MyClientInitializer());
            ChannelFuture future = bootstrap.connect("localhost", 9878).sync();
            future.channel().closeFuture().sync();
          //  future.channel().close();
        }finally {
            loopGroup.shutdownGracefully();

        }

    }
}
