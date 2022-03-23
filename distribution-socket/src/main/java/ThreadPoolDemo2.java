import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: XDwan
 * @Date:2022/3/23
 * @Description:
 * */

/*
* Demo2 为 服务器端的线程池
* */

public class ThreadPoolDemo2 {

    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,5,200,
                TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5)
        );
        System.out.println("Thread Pool has been created");
        ServerSocket serverSocket = new ServerSocket(8189);
        Socket socket = null;
        int count=0;
        System.out.println("Server listening at 8189");
        long begintime = System.currentTimeMillis();
        while (true){
            socket = serverSocket.accept();
            count++;
            System.out.println("the total number of clients is"+count);
            ServerThread serverThread = new ServerThread(socket);
            executor.execute(serverThread);
            System.out.println("Thread Pool has "+executor.getActiveCount()+" threads running now");
        }
    }
}
