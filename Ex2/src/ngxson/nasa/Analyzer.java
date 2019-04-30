package ngxson.nasa;

import ngxson.utils.Approach;
import ngxson.utils.NearEarthObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Analyzer {
    private static DataFetcher dataFetcher = new DataFetcher();

    public static HashMap<Integer, Integer> getYearlyAnalytics(int pages, int fromYear, int toYear) throws IOException, URISyntaxException {
        var nearEarthObjects = getAllNEOs(pages);
        var map = new HashMap<Integer, Integer>();
        for (NearEarthObject neo : nearEarthObjects) {
            for (Approach approach : neo.getCloseApproachData()) {
                var year = approach.getCloseApproachDate().getYear();
                var counter = map.get(year);
                counter = counter == null ? 1 : (counter + 1);
                map.put(year, counter);
            }
        }

        return map;
    }

    public static List<NearEarthObject> getAllNEOs(int pages) throws IOException, URISyntaxException {
        List<NearEarthObject> nearEarthObjects = new ArrayList<>();

        for (var i = 0 ; i < pages ; i++) {
            var doc = dataFetcher.fetch(i);
            for (NearEarthObject neo : doc.getNearEarthObjects()) {
                nearEarthObjects.add(neo);
            }
        }

        return nearEarthObjects;
    }
}
