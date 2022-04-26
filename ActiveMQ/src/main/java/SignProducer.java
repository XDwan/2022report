import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import static java.lang.Thread.sleep;

public class SignProducer extends MOMService{
    public SignProducer(String ReceiveName, String SendName) {
        super(ReceiveName, SendName);
    }

    public void sendSign(){
        Sign sign = new Sign();
        try {
            ObjectMessage message = session.createObjectMessage(new Sign());
            producer.send(message);
            System.out.println(message.getObject());
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SignProducer signProducer = new SignProducer("status","sign");
        while(true){
            signProducer.sendSign();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
