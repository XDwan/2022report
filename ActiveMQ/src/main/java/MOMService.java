import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;

public class MOMService {
    String ReceiveName;
    String SendName;
    ActiveMQConnectionFactory factory;
    Session session;
    Topic receiveQueue;
    Topic sendQueue;
    MessageProducer  producer;
    MessageConsumer consumer;
    public MOMService(String ReceiveName,String SendName){
        this.ReceiveName = ReceiveName;
        this.SendName = SendName;
        factory = new ActiveMQConnectionFactory("tcp://192.168.31.181:61616");
        factory.setTrustAllPackages(true);
        try {
            Connection connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            receiveQueue = session.createTopic(ReceiveName);
            sendQueue = session.createTopic(SendName);
            producer = session.createProducer(sendQueue);
            consumer = session.createConsumer(receiveQueue);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
