package demo.pojo;

public class userClass extends userClassKey {
    private Integer number;

    public userClass(Integer userId, Integer classId, Integer number) {
        super(userId, classId);
        this.number = number;
    }

    public userClass() {
        super();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}