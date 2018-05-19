package javaClassChina.eason.toolkit;

public class Example7 {
    private final float PI;
    protected int index;

    public Example7(final float f){
        PI = f;
        index = 0;
    }

    public static void main(String[] args) {
//        int sum = 0;
//        for (int i = 0; i < 100; i++) {
//            if(i % 7 == 0){
//                System.out.print( " + " + i);
//                sum += i;
//            }
//        }
//        System.out.println(" = " + sum);
        //50以内的素数
        for (int i = 3; i < 50; i++) {
            for (int j =2;j <= i; j++){
                if(j == i){
                    System.out.print(i+" ");
                }
                if(i % j == 0){
                    break;
                }
            }
        }
    }

}
