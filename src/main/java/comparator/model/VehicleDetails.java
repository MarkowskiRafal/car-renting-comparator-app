package comparator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class VehicleDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int passengerCapacity;
    private int smallBagsCapacity;
    private int largeBagsCapacity;
    private double trunkCapacity;
    private double fuelConsumption;
    private int freeCancellationHours;
    private boolean airConditioning;
    private boolean OcInsurance;
    private boolean theftInsurance;
    private boolean damageInsurance;
}