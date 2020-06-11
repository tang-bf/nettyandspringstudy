package thriftdemo;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import thrift.generated.PersonServese;

/**
 * @ProjectName: tbhStudy
 * @Package: thriftdemo
 * @ClassName: ThriftServer
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-05-10 14:45
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-10 14:45
 * @UpdateRemark:
 * @Version: 1.0
 */

public class ThriftServer {
    public static void main(String[] args) throws  Exception{
        TNonblockingServerSocket tNonblockingServerSocket = new TNonblockingServerSocket(8899);
        //THsHaServer.Args agr1 = new THsHaServer.Args(tNonblockingServerSocket).workerThreads(1);
        THsHaServer.Args agr = new THsHaServer.Args(tNonblockingServerSocket).minWorkerThreads(2).maxWorkerThreads(4);
        PersonServese.Processor<PersonServiceImpl> personServiceProcessor = new PersonServese.Processor<>(new PersonServiceImpl());
        agr.protocolFactory(new TCompactProtocol.Factory());
        agr.transportFactory(new TFramedTransport.Factory());
        agr.processorFactory(new TProcessorFactory(personServiceProcessor));
        TServer tServer = new THsHaServer(agr);
        System.out.println("thrift server ok ");
        tServer.serve();
    }

}
