package javaClassChina.eason.practice4.exp2;

public class MainClass {
    public static void main(String[] args) {
        TV haierTV = new TV();
        haierTV.setChannel(5);
        System.out.println("haireTV的频道是"+haierTV.getChannel());
        Family zhangSanFamily = new Family();
        zhangSanFamily.buyTV(haierTV);
        System.out.println("zhangSanFamily开始看电视节目");
        zhangSanFamily.seeTV();
        int newChannel = 2;
        System.out.println("zhangSanFamily将电视更换到"+newChannel+"频道");
        zhangSanFamily.remoteControl(newChannel);
        System.out.println("haireTV的频道是"+haierTV.getChannel()+"频道");
        zhangSanFamily.seeTV();
        Family lisiFamily = new Family();
        lisiFamily.buyTV(haierTV);
        lisiFamily.seeTV();
    }
}
