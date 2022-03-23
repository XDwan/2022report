import java.io.*;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        String userInput = null;
        String echoMessage = null;

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        Socket socket = new Socket("192.168.31.72",8189);
        System.out.println("Connect to Server");

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter out = new PrintWriter(outputStream);

        while((userInput = stdIn.readLine() )!=null){
            out.println(userInput);
            out.flush();
            echoMessage = in.readLine();
            System.out.println("Echo from server: "+ echoMessage);
        }

        socket.close();
    }
}
