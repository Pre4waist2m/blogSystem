package demo.pojo;

public class blog_class {
    private Integer classId;

    private String classContent;

    public blog_class(Integer classId, String classContent) {
        this.classId = classId;
        this.classContent = classContent;
    }

    public blog_class() {
        super();
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassContent() {
        return classContent;
    }

    public void setClassContent(String classContent) {
        this.classContent = classContent == null ? null : classContent.trim();
    }
}