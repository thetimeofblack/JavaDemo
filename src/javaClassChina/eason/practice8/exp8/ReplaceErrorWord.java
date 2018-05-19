package javaClassChina.eason.practice8.exp8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ReplaceErrorWord {

    private static Pattern pattern = null;
    private static Matcher matcher = null;

    public static void main(String[] args) {
        String str = "忘记密码，不要惊慌失错，请登陆www.yy.cn或登陆www.tt.cn";
        ReplaceErrorWord.replaceErrorWord(str);
    }

    public static void replaceErrorWord(String str){
        String regex = "登陆";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        while(matcher.find()){
            String s = matcher.group();
            System.out.println(matcher.start()+"位置出现：");
            System.out.println(s);
        }
        System.out.println("将\"登陆\"替换为\"登录\"的字符串：");
        String result = matcher.replaceAll("登录");
        System.out.println(result);
        pattern = Pattern.compile("惊慌失错");
        matcher = pattern.matcher(result);
        System.out.println("将\"惊慌失错\"替换为\"惊慌失措\"的字符串：");
        result = matcher.replaceAll("惊惶失措");
        System.out.println(result);
    }
}
