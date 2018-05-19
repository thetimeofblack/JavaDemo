package javaClassChina.eason.toolkit;

public class BubbleSorting {

    public static void main(String[] args) {
        int[] arrays = {34,56,12,43,98,1,65,44,123,5};
        bubbleSorting(arrays);
        for (int i : arrays) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSorting(int[] array){
        for (int i = 0; i < array.length; i++) {
            for(int j = 0;j < array.length - i - 1; j++){
                if(array[j] < array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}