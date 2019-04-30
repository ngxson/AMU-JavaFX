package ngxson.nasa;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import ngxson.RealFunction;
import ngxson.utils.NearEarthObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public NumberAxis numberAxis;

    @FXML
    private LineChart lineChart;

    public static DataFetcher dataFetcher = new DataFetcher();

    private XYChart.Series<Double, Double> getYearlySeries() throws IOException, URISyntaxException {
        var fromYear = 1950;
        var toYear = 2019;
        numberAxis.setForceZeroInRange(false);
        XYChart.Series<Double, Double> series = new XYChart.Series<>();
        series.setName("Asteroids frolant la Terre");
        ObservableList<XYChart.Data<Double, Double>> data = series.getData();
        var dataSource = Analyzer.getYearlyAnalytics(50, fromYear, toYear);

        for (var year = fromYear ; year <= toYear ; year++) {
            var counter = dataSource.get(year);
            var point = new XYChart.Data<Double, Double>();
            point.setXValue((double) year);
            point.setYValue((double) (counter == null ? 0 : counter));
            data.add(point);
            System.out.format("%d: %d\n", year, (counter == null ? 0 : counter));
        }

        return series;
    }

    private void addSeries(XYChart.Series<Double, Double> series) {
        lineChart.getData().add(series);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lineChart.setCreateSymbols(false);
        lineChart.setTitle("Near Earth Object");
        try {
            addSeries(getYearlySeries());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
