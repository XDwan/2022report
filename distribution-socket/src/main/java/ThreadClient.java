import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadClient {
    public static void main(String[] args) throws IOException {
        ThreadTest t1 = new ThreadTest(10);
        ThreadTest t2 = new ThreadTest(10);
        ThreadTest t3 = new ThreadTest(10);
        t1.start();
        t2.start();
        t3.start();
    }
}

class ThreadTest extends Thread{
    static int ticket = 0;
    int count;
    Socket socket;

    ThreadTest(int t) throws IOException {
        count = t;
    }

    private static synchronized int getTicket(){
        ticket++;
        return ticket;
    }

    public void run(){
        OutputStream outputStream = null;
        PrintWriter out = null;
        try {
            socket = new Socket("192.168.31.72",8189);
            outputStream = socket.getOutputStream();
            out = new PrintWriter(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println(this.getName()+" Connect to Server ");
        for (int i=0;i<count;i++){
            String message = "client " + this.getName()+" sold ticket"+ getTicket();
            System.out.println(message);
            out.println(message);
            out.flush();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        out.println("EOE");
        out.flush();
        out.close();
        try {
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
