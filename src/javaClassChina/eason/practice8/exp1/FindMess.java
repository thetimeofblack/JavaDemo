package javaClassChina.eason.practice8.exp1;

public final class FindMess {
    public static void main(String[] args) {
        String mess = "name:ZhangSan date of birth:1989.10.16. personal website:http://www.zhang.com"
                +"height:185cm, weight:72kg";
        //Name
        int index = mess.indexOf(":");
        String name = mess.substring(index+1,index+9);
        if(name.startsWith("Zhang")){
            System.out.println("简历中的姓名姓\"张\"");
        }
        //date of birth
        index = mess.indexOf(":",index+1);
        String date = mess.substring(index+1,index+11);
        System.out.println(date);

        //personal website
        int heightPosition = mess.indexOf("height");
        index = mess.indexOf(":",index+1);
        String personNet = mess.substring(index+1,heightPosition);
        System.out.println(personNet);

        //height
        index = mess.indexOf(":",heightPosition);
        //int cmPosition = mess.indexOf("cm");
        String height = mess.substring(index+1,index+4).trim();
        int h = Integer.parseInt(height);
        if(h>180){
            System.out.println("height in the resume "+h+" is over 180cm");
        }else{
            System.out.println("height in the resume "+h+" is below 180cm");
        }

        //weight
        index = mess.indexOf(":",index+1);
        //int kgPosition = mess.indexOf("kg");
        String weight = mess.substring(index+1,index+2).trim();
        int w = Integer.parseInt(weight);
        if(w >= 75){
            System.out.println("weight in the resume "+h+" is over 75kg");
        }else{
            System.out.println("weight in the resume "+h+" is below 75kg");
        }
    }
}
