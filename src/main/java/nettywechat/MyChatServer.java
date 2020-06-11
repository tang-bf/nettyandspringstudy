package nettywechat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import nettySocket.MyClientInitializer;
import nettySocket.MyServerInitializer;

/**
 * @ProjectName: tbhStudy
 * @Package: nettywechat
 * @ClassName: MyChatServer
 * @Description: server
 * @Author: tbf
 * @CreateDate: 2020-05-04 21:40
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-04 21:40
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyChatServer {
    public static void main(String[] args) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new MyChatServerInitializer());
            //.handler(new LoggingHandler());
            ChannelFuture future = serverBootstrap.bind(8989).sync();
            ChannelFuture future1 = future.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
