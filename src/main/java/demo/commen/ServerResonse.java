package demo.commen;

import demo.Const.responseStatus;

public class ServerResonse<T> {
    private int status;
    private String msg;
    private T data;

    private ServerResonse(int status){
        this.status=status;
    }
    private ServerResonse(String msg){
        this.msg=msg;
    }
    private ServerResonse(T data){
        this.data=data;
    }
    private ServerResonse(int status, String msg){
        this.status=status;
        this.msg=msg;
    }
    private ServerResonse(int status, T data){
        this.status=status;
        this.data=data;
    }
    private ServerResonse(T data, String msg){
        this.msg=msg;
        this.data=data;
    }
    private ServerResonse(int status, T data, String msg){
        this.status=status;
        this.data=data;
        this.msg=msg;
    }

    public  int getStatus(){
        return status;
    }
    public String getMsg(){
        return  msg;
    }
    public T getData(){
        return data;
    }

    public static ServerResonse CreateSuccess(String msg){ return  new ServerResonse(responseStatus.SUCCESS.getStatus(),msg); }
    public static ServerResonse CreateDefeat(String msg){return  new ServerResonse(responseStatus.ERROR.getStatus(),msg);}
    public static <T>ServerResonse CreateSuccessAndReturn(T data,String msg){
        return new ServerResonse(responseStatus.SUCCESS.getStatus(),data,msg);}

        public static <T>ServerResonse CreateSuccess(T data){
            return new ServerResonse(responseStatus.SUCCESS.getStatus(),data);
        }
}
