package ngxson.utils;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Diameter {

  @JsonProperty("kilometers")
  private Interval kilometers;

  @JsonProperty("meters")
  private Interval meters;

  @JsonProperty("miles")
  private Interval miles;

  @JsonProperty("feet")
  private Interval feet;


  public double getKilometersMin() {
    return kilometers.getEstimatedDiameterMin();
  }
  public double getKilometersMax() {
    return kilometers.getEstimatedDiameterMax();
  }

  public double getMetersMin() {
    return meters.getEstimatedDiameterMin();
  }
  public double getMetersMax() {
    return meters.getEstimatedDiameterMax();
  }


}
