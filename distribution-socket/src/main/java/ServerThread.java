import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
    Socket socket = null;
    static int count = 0;
    ServerThread(Socket socket){
        this.socket = socket;
    }
    public  void run(){
        System.out.println(Thread.currentThread().getName() + " start ");
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;

        try {
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);
            String info = null;
            while((info = reader.readLine())!=null && ! info.equals("EOE")){
                System.out.println("ServerThread "+this.getName()+" read "+info);
            }
            reader.close();
            inputStreamReader.close();
            inputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
