/**
 * @Author: XDwan
 * @Date:2022/4/26
 * @Description:
 **/


import java.awt.Color;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
        import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import static java.lang.Thread.sleep;


public class TestDraw {

    XYSeriesCollection dataset;
    XYSeries Series1;
    TimeSeries timeSeries2;
    TimeSeries timeSeries3;
    long startTime= System.currentTimeMillis();
    private XYDataset createDataset() {
        dataset = new XYSeriesCollection();
        Day day = new Day(21, 9, 2008);
        Hour hour22 = new Hour(22, day);
        Hour hour23 = new Hour(23, day);
        Series1 = new XYSeries("A");
        for (int i=0;i<10;i++){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            Series1.add(endTime - startTime,i);
        }

        dataset.addSeries(Series1);

        return dataset;
    }

    public void createTimeSeriesChart() {
        JFreeChart timeSeriesChart = ChartFactory.createTimeSeriesChart(
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
    }

    public static void main(String[] args) {
        TestDraw draw = new TestDraw();
        draw.createDataset();
        draw.createTimeSeriesChart();
    }
}
