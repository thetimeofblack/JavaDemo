package javaClassChina.eason.toolkit;

/**
 * shows square equation like ax^2+bx+c = 0;
 * */
public class SquareEquation {
    double a,b,c;
    double root1,root2;
    boolean boo; //判断是否为二元一次方程

    public SquareEquation(double a,double b,double c){
        this.a = a;
        this.b = b;
        this.c = c;
        if(a!=0){
            boo = Boolean.TRUE;
        }else{
            boo = Boolean.FALSE;
        }
    }

    public void getRoots(){
        if(this.boo){
            System.out.println("是一元二次方程");
            double disk = b*b - 4*a*c;
            if(disk >= 0){
                this.root1 = (-b + Math.sqrt(disk))/(2*a);
                this.root2 = (-b - Math.sqrt(disk))/(2*a);
                System.out.printf("方程的根:%.5f,%.5f\n",root1,root2);
            }else{
                System.out.println("方程没有实根");
            }
        }else{
            System.out.println("不是二元一次方程");
        }
    }

    public void setCoefficient(double a,double b,double c){
        this.a = a;
        this.b = b;
        this.c = c;
        if(a!=0){
            boo = Boolean.TRUE;
        }else{
            boo = Boolean.FALSE;
        }
    }
}
