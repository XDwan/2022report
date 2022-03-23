import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo1 {
    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newFixedThreadPool(5);
//        for (int i=0;i<10;i++){
//            service.submit(()->{
//                System.out.println("thread id is "+ Thread.currentThread().getName());
//            });
//        }
        service.submit(new ThreadTest(10));
    }
}
