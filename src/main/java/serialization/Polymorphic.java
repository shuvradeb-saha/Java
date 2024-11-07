package serialization;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

public class Polymorphic {
  public static void main(String[] args) throws JsonProcessingException {
    String json = "{\"type\":\"FUEL_VEHICLE\",\"fuelType\":\"500\",\"transmissionType\":\"200\"}";
    Vehicle vehicle = new ObjectMapper().readerFor(Vehicle.class).readValue(json);
    System.out.println(vehicle.getClass().getSimpleName());
  }

  @Data
  @JsonTypeInfo(
      use = JsonTypeInfo.Id.NAME,
      include = JsonTypeInfo.As.EXISTING_PROPERTY,
      property = "type",
      visible = true)
  @JsonSubTypes({
    @JsonSubTypes.Type(value = ElectricVehicle.class, name = "ELECTRIC_VEHICLE"),
    @JsonSubTypes.Type(value = FuelVehicle.class, name = "FUEL_VEHICLE")
  })
  public static class Vehicle {
    private String type;
  }

  @Data
  @EqualsAndHashCode(callSuper = true)
  private static class ElectricVehicle extends Vehicle {
    private String autonomy;
    private String chargingTime;
  }

  @Data
  @EqualsAndHashCode(callSuper = true)
  private static class FuelVehicle extends Vehicle {
    private String fuelType;
    private String transmissionType;
  }
}
