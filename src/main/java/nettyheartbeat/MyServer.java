package nettyheartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import nettywechat.MyChatServerInitializer;

/**
 * @ProjectName: tbhStudy
 * @Package: nettyheartbeat
 * @ClassName: MyServer
 * @Description: heartbeatserver
 * @Author: tbf
 * @CreateDate: 2020-05-05 13:36
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-05 13:36
 * @UpdateRemark:
 * @Version: 1.0
 */
//test 客户端使用wechat中客户端代码
public class MyServer {
    public static void main(String[] args) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new MyServerInitializer());
            //.handler(new LoggingHandler());
            ChannelFuture future = serverBootstrap.bind(8989).sync();
            ChannelFuture future1 = future.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
