package codecdemo;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;


public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline pipeline = ch.pipeline();
       // pipeline.addLast(new MyClientHandler());  编解码顺序和处理业务顺序要正确，否则服务器客户端传输消息不通
        //加入一个出站的handler 对数据进行一个编码
        pipeline.addLast(new MyLongToByteEncoder());

        //这时一个入站的解码器(入站handler )
        pipeline.addLast(new MyByteToLongDecoder());
        //pipeline.addLast(new MyByteToLongDecoder2());
        //加入一个自定义的handler ， 处理业务
        pipeline.addLast(new MyClientHandler());


    }
}
