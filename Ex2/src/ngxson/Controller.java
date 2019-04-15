package ngxson;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private LineChart lineChart;

    private XYChart.Series<Double, Double> getSeries(RealFunction fn,
                                                     String name,
                                                     double minValue,
                                                     double maxValue,
                                                     double dx) {
        XYChart.Series<Double, Double> series = new XYChart.Series<>();
        series.setName(name);
        ObservableList<XYChart.Data<Double, Double>> data = series.getData();
        for (double x = minValue; x <= maxValue; x = x + dx) {
            XYChart.Data<Double, Double> point = new XYChart.Data<>();
            point.setXValue(x);
            point.setYValue(fn.apply(x));
            data.add(point);
        }

        return series;
    }

    private XYChart.Series<Double, Double> getCosineSeries(double minValue,
                                                           double maxValue,
                                                           double dx) {
        RealFunction cosFn = x -> Math.cos(x);
        return getSeries(cosFn, "Cosine", minValue, maxValue, dx);
    }

    private XYChart.Series<Double, Double> getSineSeries(double minValue,
                                                           double maxValue,
                                                           double dx) {
        RealFunction sinFn = x -> Math.sin(x);
        return getSeries(sinFn, "Sine", minValue, maxValue, dx);
    }

    private XYChart.Series<Double, Double> getExpSeries(double minValue,
                                                         double maxValue,
                                                         double dx) {
        RealFunction expFn = x -> Math.exp(x);
        return getSeries(expFn, "Exponential", minValue, maxValue, dx);
    }

    private XYChart.Series<Double, Double> getParabolSeries(double minValue,
                                                        double maxValue,
                                                        double dx) {
        RealFunction parabolFn = x -> Math.pow(2, x);
        return getSeries(parabolFn, "Parabol", minValue, maxValue, dx);
    }

    private void addSeries(XYChart.Series<Double, Double> series) {
        lineChart.getData().add(series);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lineChart.setCreateSymbols(false);
        lineChart.setTitle("My First Graph");
        addSeries(getCosineSeries(0, 10, 0.1));
        addSeries(getSineSeries(0, 10, 0.1));
        addSeries(getExpSeries(0, 10, 0.1));
        addSeries(getParabolSeries(0, 10, 0.1));
    }
}
