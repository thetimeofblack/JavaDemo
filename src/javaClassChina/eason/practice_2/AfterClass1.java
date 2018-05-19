package javaClassChina.eason.practice_2;

/**show sum of two Arrays using for-loop, while and do-while*/
public class AfterClass1 {
    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6,7,8,9,10};
        char b[]={'a','b','c','d','e','f','g','h','i','j'};
        AfterClass1.showArrays(AfterClass1.addArrayUsingFor(a,b));
        AfterClass1.showArrays(AfterClass1.addArrayUsingWhile(a,b));
        AfterClass1.showArrays(AfterClass1.addArrayUsingDoWhile(a,b));
    }
    /**method for printing Arrays*/
    public static void showArrays(int[] array){
        for (Object i : array) {
            System.out.print( i + " ");
        }
        System.out.println();
    }
    /**show sum of two Arrays using for-loop*/
    public static int[] addArrayUsingFor(int[] a,char[] b){
        int []result = new int[a.length];
        for (int i = 0; i < a.length; i+=1) {
            result[i] = a[i] + (int)b[i];
        }
        return result;
    }
    /**show sum of two Arrays using while*/
    public static int[] addArrayUsingWhile(int[] a,char[] b){
        int []result = new int[a.length];
        int i = 0;
        while(i < a.length){
            result[i] = a[i] + (int)b[i];
            i+=1;
        }
        return result;
    }
    /**show sum of two Arrays using do-while*/
    public static int[] addArrayUsingDoWhile(int[] a,char[] b){
        int []result = new int[a.length];
        int i = 0;
        do{
            result[i] = a[i] + (int)b[i];
            i+=1;
        }while(i < a.length);
        return result;
    }
}
