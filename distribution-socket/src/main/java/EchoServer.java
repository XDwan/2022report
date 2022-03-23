import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = null;
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server listening at 8189");
        clientSocket = serverSocket.accept();
        System.out.println("Accept connection from client");

        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter out = new PrintWriter(outputStream);

        String line = null;
        while ((line = in.readLine())!=null){
            System.out.println("Message from client: "+line);
            out.println(line);
            out.flush();
        }
        clientSocket.close();
        serverSocket.close();
    }
}
