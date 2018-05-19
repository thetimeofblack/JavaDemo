package javaClassChina.eason.toolkit;

@FunctionalInterface
interface Cubic {
    public double getCubic(int n);
}

@FunctionalInterface
interface  Sqrt {
    public double getSqrt(int x);
}

class A {
    void f(Cubic cubic) {
        double result=cubic.getCubic(3); //执行匿名类体中实现的getCubic方法
        System.out.println(result);
    }
}
class Example4_32 {
    public static void main(String args[]) {
        A a=new A();
        a.f(new Cubic() {
            @Override
            public double getCubic(int n) {
                return n*n*n;
            }
        });
        Sqrt ss=new Sqrt() {
            public double getSqrt(int x){
                return Math.sqrt(x);
            }
        };
        double m=ss.getSqrt(9); //接口回调
        System.out.println(m);
    }
}

