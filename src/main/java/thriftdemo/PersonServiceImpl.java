package thriftdemo;

import org.apache.thrift.TException;
import thrift.generated.Person;
import thrift.generated.PersonServese;
import thrift.generated.dataException;

/**
 * @ProjectName: tbhStudy
 * @Package: thriftdemo
 * @ClassName: PersonServiceImpl
 * @Description: personServiceIMpl
 * @Author: tbf
 * @CreateDate: 2020-05-10 14:39
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-05-10 14:39
 * @UpdateRemark:
 * @Version: 1.0
 */

public class PersonServiceImpl implements PersonServese.Iface {
    @Override
    public Person getPersonByName(String userName) throws dataException, TException {
        System.out.println("got client param :"+userName);
        Person person = new Person();
        person.setAge(20).setUsername(userName);
        return person;
    }

    @Override
    public void save(Person person) throws dataException, TException {
        System.out.println("param:"+person);
        System.out.println(person.getAge()+""+ person.getUsername());
    }
}
