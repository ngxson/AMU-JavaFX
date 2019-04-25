package ngxson.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class NearEarthObject {

  @JsonProperty("orbital_data")
  private OrbitalData orbital_data;
    
  public NEOLink getLinks() {
    return links;
  }

  public String getNeoReferenceId() {
    return neoReferenceId;
  }

  public String getDesignation() {
    return designation;
  }

  public String getNasaJplUrl() {
    return nasaJplUrl;
  }

  public double getAbsoluteMagnitudeH() {
    return absoluteMagnitudeH;
  }

  public String getName() {
    return name;
  }


  public boolean isPotentiallyHazardous() {
    return isPotentiallyHazardous;
  }

  public List<Approach> getCloseApproachData() {
    return Arrays.asList(closeApproachData);
  }

  public OrbitalData getOrbitalData() {
    return orbital_data;
  }

  public boolean isSentryObject() {
    return true;
  }

  private NEOLink links;

  @JsonProperty("neo_reference_id")
  private String neoReferenceId;

  private String designation;

  @JsonProperty("nasa_jpl_url")
  private String nasaJplUrl;

  @JsonProperty("absolute_magnitude_h")
  private double absoluteMagnitudeH;

  private String name;

  @JsonProperty("is_potentially_hazardous_asteroid")
  private boolean isPotentiallyHazardous;

  @JsonProperty("close_approach_data")
  private Approach[] closeApproachData;

  @JsonProperty("estimated_diameter")
  private Diameter estimated_diameter;


  public Diameter getEstimatedDiameter() {
    return estimated_diameter;
  }
}
