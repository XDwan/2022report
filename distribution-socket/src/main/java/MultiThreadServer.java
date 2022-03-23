import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        Socket socket = null;

        int count=0;
        System.out.println("Server listening at 8189");

        while (true){
            socket = serverSocket.accept();
            count++;
            System.out.println("the total number of clients is"+count);
            ServerThread serverThread = new ServerThread(socket);
            serverThread.start();
        }
    }
}
