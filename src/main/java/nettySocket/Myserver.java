package nettySocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import nettyDemo.TestServerInitializer;

import javax.lang.model.element.VariableElement;

/**
 * @ProjectName: tbhStudy
 * @Package: nettySocket
 * @ClassName: Myserver
 * @Description: socket
 * @Author: tbf
 * @CreateDate: 2020-05-04 15:57
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-04 15:57
 * @UpdateRemark:
 * @Version: 1.0
 */

public class Myserver {
    public static void main(String[] args) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new MyServerInitializer());
            //.handler(new LoggingHandler());
            java.nio.channels.SocketChannel.open();
            ChannelFuture future = serverBootstrap.bind(9878).sync();
           // future.addListener()
            ChannelFuture future1 = future.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
