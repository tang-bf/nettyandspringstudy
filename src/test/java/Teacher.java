import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @ProjectName: tbhStudy
 * @Package: PACKAGE_NAME
 * @ClassName: Teacher
 * @Description:
 * @Author: tbf
 * @CreateDate: 2021-11-01 23:49
 * @UpdateUser: Administrator
 * @UpdateDate: 2021-11-01 23:49
 * @UpdateRemark:
 * @Version: 1.0
 */

@XmlAccessorType(XmlAccessType.FIELD)

public class Teacher {
    @XmlElement(name="teacherName")
    private String teacherName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
