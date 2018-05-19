package javaClassChina.eason.practice4.exp2;

public class TV {
    public int getChannel() {
        return channel;
    }
    public void setChannel(int channel) {
        if(channel >= 1){
            this.channel = channel;
        }
    }
    int channel;    //TV Channel

    void showProgram(){
        switch (this.channel){
            case 1:
                System.out.println("综合频道");
                break;
            case 2:
                System.out.println("经济频道");
                break;
            case 3:
                System.out.println("文艺频道");
                break;
            case 4:
                System.out.println("国际频道");
                break;
            case 5 :
                System.out.println("国际频道");
                break;
            default:
                System.out.println("不能收看"+this.channel+"频道");
        }
    }

}
