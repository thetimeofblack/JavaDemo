package javaClassChina.eason.practice8.exp8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {
        String str = "清华大学出版社 http://www.tup.com 是著名出版社，尤其在计算机图书方面";
        String str2 = "新浪：www.sina.com, 央视：http://www.cctv.com";
        String regex = "(http://|www)\56?\\w+\56{1}\\w+\56{1}\\p{Alpha}+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str2);
        while(matcher.find()){
            String result = matcher.group();
            System.out.println(result);
        }
    }
}
