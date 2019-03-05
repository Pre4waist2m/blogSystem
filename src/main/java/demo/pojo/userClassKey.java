package demo.pojo;

public class userClassKey {
    private Integer userId;

    private Integer classId;

    public userClassKey(Integer userId, Integer classId) {
        this.userId = userId;
        this.classId = classId;
    }

    public userClassKey() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}