package ngxson.nasa;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import ngxson.RealFunction;
import ngxson.utils.NearEarthObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private LineChart lineChart;

    public static DataFetcher dataFetcher = new DataFetcher();

    private XYChart.Series<Double, Double> getSeries(int max_pages) throws IOException, URISyntaxException {
        XYChart.Series<Double, Double> series = new XYChart.Series<>();
        series.setName("Asteroids frolant la Terre");
        ObservableList<XYChart.Data<Double, Double>> data = series.getData();

        for (var i = 0 ; i < max_pages ; i++) {
            for (NearEarthObject neo : dataFetcher.fetch(i).getNearEarthObjects()) {
                XYChart.Data<Double, Double> point = new XYChart.Data<>();
                point.setXValue(1.0);
                point.setYValue(1.0);
                data.add(point);
            }
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
            addSeries(getSeries(1));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
