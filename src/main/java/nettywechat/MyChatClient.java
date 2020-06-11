package nettywechat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import nettySocket.MyClientInitializer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ProjectName: tbhStudy
 * @Package: nettywechat
 * @ClassName: MyChatClient
 * @Description: chatclient
 * @Author: tbf
 * @CreateDate: 2020-05-05 10:33
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-05 10:33
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyChatClient {
    public static void main(String[] args) throws  Exception{
        EventLoopGroup loopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(loopGroup).channel(NioSocketChannel.class)
                    .handler(new MyChatClientInitializer());
            Channel channel = bootstrap.connect("localhost", 8989).sync().channel();
          //  Channel channel = future.channel();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            for (;;) {
                channel.writeAndFlush(bufferedReader.readLine() + "\r\n");
            }
        }finally {
            loopGroup.shutdownGracefully();

        }

    }
}
