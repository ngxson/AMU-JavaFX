package ngxson.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Velocity {
    @JsonProperty("kilometers_per_second")
    String kilometers_per_second;

    @JsonProperty("kilometers_per_hour")
    String kilometers_per_hour;

    @JsonProperty("miles_per_hour")
    String miles_per_hour;

    public double getKilometersPerHour() {
        return Double.valueOf(kilometers_per_hour);
    }

    public double getKilometersPerSecond() {
        return Double.valueOf(kilometers_per_second);
    }
}
