package demo.Const;

public enum responseStatus {
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    ILLEGAL(2,"ILLEGAL");
    private final int status;
    private final String desc;
    responseStatus(int status,String desc){
        this.desc=desc;
        this.status=status;
    }
    public int getStatus(){
        return status;
    }
    public String getDesc(){
        return desc;
    }
}
