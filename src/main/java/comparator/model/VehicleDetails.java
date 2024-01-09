package comparator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @PositiveOrZero(message = "Passenger capacity should be positive")
    private int passengerCapacity;

    @PositiveOrZero(message = "Number of trunk capacity should be positive")
    private double trunkCapacity;

    @PositiveOrZero(message = "Number of small bags capacity should be positive")
    private int smallBagsCapacity;

    @PositiveOrZero(message = "Number of large bags capacity should be positive")
    private int largeBagsCapacity;

    @PositiveOrZero(message = "Number of fuel consumption per 100 kilometers should be positive")
    private double fuelConsumptionPer100Km;

    @PositiveOrZero(message = "Number of free cancellation hours should be positive")
    private int freeCancellationHours;

    private boolean isAirConditioning;
    private boolean isOcInsurance;
    private boolean isTheftInsurance;
    private boolean isDamageInsurance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleDetails that = (VehicleDetails) o;
        return getId() == that.getId() && getPassengerCapacity() == that.getPassengerCapacity() && Double.compare(that.getTrunkCapacity(), getTrunkCapacity()) == 0 && getSmallBagsCapacity() == that.getSmallBagsCapacity() && getLargeBagsCapacity() == that.getLargeBagsCapacity() && Double.compare(that.getFuelConsumptionPer100Km(), getFuelConsumptionPer100Km()) == 0 && getFreeCancellationHours() == that.getFreeCancellationHours() && isAirConditioning() == that.isAirConditioning() && isOcInsurance() == that.isOcInsurance() && isTheftInsurance() == that.isTheftInsurance() && isDamageInsurance() == that.isDamageInsurance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPassengerCapacity(), getTrunkCapacity(), getSmallBagsCapacity(), getLargeBagsCapacity(), getFuelConsumptionPer100Km(), getFreeCancellationHours(), isAirConditioning(), isOcInsurance(), isTheftInsurance(), isDamageInsurance());
    }
}