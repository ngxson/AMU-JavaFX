package ngxson.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Distance {
    
  public double getAstronomical() {
    return astronomical;
  }

  public double getLunar() {
    return lunar;
  }

  public double getKilometers() {
    return kilometers;
  }

    
  private double astronomical;
  private double lunar;
  private double kilometers;

}
