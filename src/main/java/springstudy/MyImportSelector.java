package springstudy;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ProjectName: tbhStudy
 * @Package: springstudy
 * @ClassName: MyImportSelector
 * @Description:
 * @Author: tbf
 * @CreateDate: 2020-06-14 22:26
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-06-14 22:26
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{UserDao.class.getName()};
    }
}
