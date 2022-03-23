import java.io.IOException;
import java.util.concurrent.*;

/*
 * Demo1 为 服务器端的线程池
 * */

public class ThreadPoolDemo1 {
    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,7,200,
                TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5)
        );
        for (int i=0;i<10;i++){
            executor.execute(new ThreadTest(10));
            System.out.println(executor.getActiveCount());
        }

//        executor.execute(new ThreadTest(10));
//        System.out.println(executor.getActiveCount());
//        executor.execute(new ThreadTest(10));
//        System.out.println(executor.getActiveCount());
    }
}
