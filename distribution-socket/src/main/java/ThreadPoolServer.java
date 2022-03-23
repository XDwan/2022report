import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolServer {
    public static void main(String[] args) throws IOException {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,7,1e5, TimeUnit.SECONDS,new ,new testThreadPoolFactory())
    }
}

class testThreadPoolFactory implements ThreadFactory{

    ServerSocket serverSocket;
    Socket socket = null;
    int count = 0;

    public testThreadPoolFactory() throws IOException {
        serverSocket = new ServerSocket(8189);
        System.out.println("Server listening at 8189");
    }
    @Override
    public Thread newThread(Runnable r) {

        return null;
    }
}
