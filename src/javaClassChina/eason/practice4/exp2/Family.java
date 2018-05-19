package javaClassChina.eason.practice4.exp2;

public class Family {
    TV homeTV;

    void buyTV(TV tv){
        this.homeTV = tv;
    }

    void remoteControl(int channel){
        this.homeTV.setChannel(channel);
    }

    void seeTV(){
        homeTV.showProgram();
    }
}
