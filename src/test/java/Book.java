import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"bookName","time","author","teacher"})
public class Book {
    @XmlElement(name="BookName")
    private String bookName;
    @XmlElement(name="Time")
    private String time;
    @XmlElement(name="Author")
    private String author;
    @XmlElement(name="teacher")
    private Teacher teacher;
    public String getBookName() {
        return bookName;
    }
    public String getTime() {
        return time;
    }
    public String getAuthor() {
        return author;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}