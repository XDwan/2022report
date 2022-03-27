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
* 为了方便比较多线程下的服务端压力，使用售票的例子，对服务器端进行过量访问
* */

public class ThreadPoolServer {

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
