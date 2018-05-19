package coreJava.chapter6;

/**首先做的就是使用lambda表达式替换匿名类，而实现Runnable接口是匿名类的最好示例。
 * 看一下Java 8之前的runnable实现方法，需要4行代码，而使用lambda表达式只需要一行代码。我们在这里做了什么呢？
 * 那就是用() -> {}代码块替代了整个匿名类。*/
public final class RunnableLambda implements Runnable{

    public static void main(String[] args) {

        //the most complicated way is to create an object
        new Thread(new RunnableLambda()).start();

        //before Java8
        new Thread(new Runnable() { //compiler notice:Anonymous class can be replaced by lambda expression.
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();
        //Java 8 using expression lambda: simple but efficient
        new Thread(() -> System.out.println("Now in Java 8 we use lambda expression") ).start();

    }

    @Override
    public void run() {
        System.out.println("the most complicated way is to create an object");
    }
}
