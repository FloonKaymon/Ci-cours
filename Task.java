import java.util.Date;

public class Task {
    
    private String name;
    private String content;
    private Date creationDate;


    public Task(String name, String content, Date creationDate) {
        this.name = name;
        this.content = content;
        this.creationDate = creationDate;
    }

    public Task(String name, String content) {
        this.name = name;
        this.content = content;
        this.creationDate = new Date();
    }

    public boolean save() {
        throw new UnsupportedOperationException();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
