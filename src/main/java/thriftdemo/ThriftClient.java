package thriftdemo;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift.generated.Person;
import thrift.generated.PersonServese;

/**
 * @ProjectName: tbhStudy
 * @Package: thriftdemo
 * @ClassName: ThriftClient
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-05-10 14:57
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-10 14:57
 * @UpdateRemark:
 * @Version: 1.0
 */

public class ThriftClient {
    public static void main(String[] args) {
        TTransport tTransport = new TFramedTransport(new TSocket("localhost",8899),600) ;
        TProtocol tProtocol = new TCompactProtocol(tTransport);
        PersonServese.Client client = new PersonServese.Client(tProtocol);
        try {
            tTransport.open();
            Person p1 = client.getPersonByName("张三");
            System.out.println(p1.getAge());
            Person p2 = new Person();
            p2.setAge(11);
            client.save(p2);
        }catch (Exception e){

        }
    }
}
