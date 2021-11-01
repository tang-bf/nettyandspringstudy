import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ROOT")
@XmlType(propOrder={"name","age","books"})
public class ListSocket {

    @XmlElement(name="Name",required=true)
    private String name;
    @XmlElement(name="Age",required=true)
    private String age;
    @XmlElementWrapper(name="ROWS")//@XmlElementWrapper注解表示生成一个包装 XML 表示形式的包装器元素。 此元素主要用于生成一个包装集合的包装器 XML 元素
    @XmlElement(name="LIST",required=true)
    private List<Book> books;
    public String getName() {
        return name;
    }
    public String getAge() {
        return age;
    }
    public List<Book> getBooks() {
        return books;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String toString(){
        String result = "";
        result=this.age+","+this.name+",集合的数据：";
        for (Book book:books) {
            result+=book.getAuthor()+book.getTime()+book.getBookName();
        }
        return result;
    }
}