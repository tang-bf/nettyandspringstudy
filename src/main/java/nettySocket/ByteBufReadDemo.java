package nettySocket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @ProjectName: tbhStudy
 * @Package: nettySocket
 * @ClassName: ByteBufReadDemo
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-05-14 23:14
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-14 23:14
 * @UpdateRemark:
 * @Version: 1.0
 */

public class ByteBufReadDemo {
    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.buffer(10);
        for (int i = 0; i < byteBuf.capacity(); i++) {
            byteBuf.writeByte(i);
        }
        for (int i = 0; i < byteBuf.capacity(); i++) {
            System.out.println(byteBuf.readByte());
        }
        for (int i = 0; i < byteBuf.capacity(); i++) {
            System.out.println(byteBuf.readByte());
        }
    }
}
