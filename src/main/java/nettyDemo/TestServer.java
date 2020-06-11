package nettyDemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @ProjectName: tbhStudy
 * @Package: nettyDemo
 * @ClassName: TestServer
 * @Description: nettyServer
 * @Author: tbf
 * @CreateDate: 2020-05-04 13:58
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-04 13:58
 * @UpdateRemark:
 * @Version: 1.0
 */

public class TestServer {
    public static void main(String[] args) throws Exception{
        /**
         * private static final int DEFAULT_EVENT_LOOP_THREADS;
         *
         *     static {
         *         DEFAULT_EVENT_LOOP_THREADS = Math.max(1, SystemPropertyUtil.getInt(
         *                 "io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
         *
         *         if (logger.isDebugEnabled()) {
         *             logger.debug("-Dio.netty.eventLoopThreads: {}", DEFAULT_EVENT_LOOP_THREADS);
         *         }
         *     }
         *
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup).channel( NioServerSocketChannel.class)
                    .childHandler(new TestServerInitializer()).handler(new LoggingHandler(LogLevel.DEBUG));
            ChannelFuture future = serverBootstrap.bind(9989).sync();
            ChannelFuture future1 = future.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }
}
