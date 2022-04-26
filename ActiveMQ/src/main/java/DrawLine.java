import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

import static java.lang.Thread.sleep;

/**
 * @Author: XDwan
 * @Date:2022/4/26
 * @Description:
 **/
public class DrawLine {
    XYSeriesCollection dataset;
    XYSeries Series1;
    JFreeChart timeSeriesChart;
    int count = 0;
    int N = 100;
    long startTime= System.currentTimeMillis();
    public XYDataset createDataset() {
        dataset = new XYSeriesCollection();
        Series1 = new XYSeries("A");
        dataset.addSeries(Series1);
        return dataset;
    }

    public void createTimeSeriesChart() {
        timeSeriesChart = ChartFactory.createTimeSeriesChart(
                "Sign", "Time", "Value", dataset, true,
                true, false);
        timeSeriesChart.setBackgroundPaint(Color.WHITE);
        XYPlot plot = timeSeriesChart.getXYPlot();
        setXYPolt(plot);
        ChartFrame frame = new ChartFrame("TestPieChart", timeSeriesChart);
        frame.pack();
        frame.setVisible(true);
    }

    public static void setXYPolt(XYPlot plot) {
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
        // plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;

            renderer.setDefaultShapesFilled(false);
            renderer.setDefaultShapesVisible(true);
        }
    }

    public void update(double sign){
        long endTime = System.currentTimeMillis();
        Series1.add(endTime - startTime,sign);
        count++;
        if (count >= N){
            Series1.delete(0,0);
            count--;
        }
    }

    public static void main(String[] args) {
        DrawLine draw = new DrawLine();
        draw.createDataset();
        draw.createTimeSeriesChart();
        for (int i=0;i<10;i++){
            try {
                sleep(100);
                draw.update(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
