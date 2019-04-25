package ngxson.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Approach {

  @JsonProperty("close_approach_date")
  private String close_approach_date;

  @JsonProperty("epoch_date_close_approach")
  private long epoch_date_close_approach;

  @JsonProperty("relative_velocity")
  private Velocity relative_velocity;

  @JsonProperty("miss_distance")
  private Distance miss_distance;

  @JsonProperty("orbiting_body")
  private String orbiting_body;

  public LocalDate getCloseApproachDate() {
    return LocalDate.parse(close_approach_date);
  }

  public long getEpochDateCloseApproach() {
    return epoch_date_close_approach;
  }

  public Velocity getRelativeVelocity() {
    return relative_velocity;
  }

  public Distance getMissDistance() {
    return miss_distance;
  }

  public String getOrbitingBody() {
    return orbiting_body;
  }


}
