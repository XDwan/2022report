import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

public class DataShower extends MOMService {
    Topic signTopic;
    Topic resultTopic;
    MessageConsumer signConsumer;
    MessageConsumer resultConsumer;
    DrawLine drawLine;
    List<Double> signs;
    Result showResult;

    public DataShower(String ReceiveName, String SendName) {
        super(ReceiveName, SendName);
        drawLine = new DrawLine();
        drawLine.createDataset();
        drawLine.createTimeSeriesChart();
        signs = new ArrayList<>();
        try {
            signTopic = session.createTopic("sign");
            resultTopic = session.createTopic("result");
            signConsumer = session.createConsumer(signTopic);
            resultConsumer = session.createConsumer(resultTopic);
            signConsumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    ObjectMessage signMessage = (ObjectMessage) message;
                    try {
                        Sign getSign = (Sign) signMessage.getObject();
                        signs.add(getSign.sign);
                        drawLine.update(getSign.sign);
                        System.out.println(getSign);
                    } catch (JMSException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(signs.size());
                }
            });
            resultConsumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    ObjectMessage signMessage = (ObjectMessage) message;
                    try {
                        showResult = (Result) signMessage.getObject();
                        drawLine.timeSeriesChart.setTitle(showResult.toString());
                        System.out.println(showResult);
                    } catch (JMSException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DataShower shower = new DataShower("result","result");
    }
}
