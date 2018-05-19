package javaClassChina.eason.practice8.exp2;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class ComputerPrice {

    public static void main(String[] args) {
        String menu = "北京烤鸭：189元 西芹炒肉：12.9元 酸菜鱼：69元 铁板牛柳：32元";
        String str = "中央电视台:www.cctv.com 清华大学:www.tsinghua.edu.cn 音乐网站:www.violin.com";
        Scanner reader = new Scanner(str);
        String regex = "[^0123456789.]+";
        String webRegex = "[^(http//||www)\56?\\w+\56{1}\\w+\56{1}\\p{Alpha}]+";
        reader.useDelimiter(webRegex);
//        double sum = 0;
        while(reader.hasNext()){
            try {
                String website = reader.next();
                System.out.println(website);
//                double price = reader.nextDouble();
//                sum += price;
//                System.out.println(price);
            } catch (InputMismatchException exp) {
                String t = reader.next();
            }
        }
//        System.out.println("菜单总价格："+sum+"元");
    }
}