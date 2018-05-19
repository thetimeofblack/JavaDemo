package javaClassChina.eason.practice7.exp2;

public class DangerException extends Exception {
    private String message;

    public DangerException(){
        this.message = "是危险品";
    }

    public void toShow(){
        System.out.println(this.message+" ");
    }
}
