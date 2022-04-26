import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.Styler.*;

import javax.jms.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DataShower extends MOMService {
    Topic signTopic;
    Topic resultTopic;
    MessageConsumer signConsumer;
    MessageConsumer resultConsumer;

    List<Double> signs;
    Result showResult;

    public DataShower(String ReceiveName, String SendName) {
        super(ReceiveName, SendName);
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
                        Sign sign = (Sign) signMessage.getObject();
                        signs.add(sign.sign);
                        System.out.println(sign);
                    } catch (JMSException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            resultConsumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    ObjectMessage signMessage = (ObjectMessage) message;
                    try {
                        showResult = (Result) signMessage.getObject();
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
        DataShower shower = new DataShower("sign", "result");
        boolean first = true;
        XYChart chart = null;
        SwingWrapper<XYChart> swingWrapper = null;
        while (true) {
            if (shower.signs.isEmpty()) {
                continue;
            }

            if (first) {
                chart = new XYChartBuilder().width(600).height(450).theme(Styler.ChartTheme.Matlab).title("sign").build();
                chart.addSeries("sign", null, shower.signs);
                chart.getStyler().setLegendLayout(LegendLayout.Horizontal);// 设置legend的排列方式为水平排列
                swingWrapper = new SwingWrapper<XYChart>(chart);
                JFrame frame = swingWrapper.displayChart();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
            first = false;
            chart.updateXYSeries("sign", null, shower.signs, null);
            swingWrapper.repaintChart();
        }

    }
}
