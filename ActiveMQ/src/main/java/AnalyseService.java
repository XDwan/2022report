import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.IOException;

public class AnalyseService extends MOMService {
    public AnalyseService(String ReceiveName, String SendName) throws IOException {
        super(ReceiveName, SendName);
    }

    Double[] signs;
    Result result;

    public void receiveSign() {
        int N = 100; // 收集100个信号量进行分析；
        signs = new Double[N];
        for (int i = 0; i < N; i++) {
            try {
                ObjectMessage message = (ObjectMessage) consumer.receive();
                System.out.println(message.getObject());
                Sign s = (Sign) message.getObject();
                signs[i] = s.sign;
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public double getMean() {
        double mean = 0;
        for (Double sign : signs) mean += sign;
        return mean / signs.length;
    }

    public double getVar() {
        double var = 0;
        double mean = getMean();
        for (Double sign : signs) var += Math.pow(sign - mean, 2);
        return var / signs.length;
    }

    public double getMin() {
        double min = Integer.MAX_VALUE;
        for (Double sign : signs) {
            if (sign < min) min = sign;
        }
        return min;
    }

    public double getMax() {
        double max = Integer.MIN_VALUE;
        for (Double sign : signs) {
            if (sign > max) max = sign;
        }
        return max;
    }

    public void analyse() {
        result = new Result();
        result.mean = getMean();
        result.var = getVar();
        result.max = getMax();
        result.min = getMin();
        System.out.println(result);
    }

    public void sendResult() {
        try {
            ObjectMessage message = session.createObjectMessage(result);
            producer.send(message);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        AnalyseService analyseService = new AnalyseService("sign", "result");
        while(true){
            analyseService.receiveSign();
            analyseService.analyse();
            analyseService.sendResult();
        }
    }
}
