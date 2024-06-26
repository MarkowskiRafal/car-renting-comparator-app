package comparator.vehicle.model;

import comparator.rental.model.Rental;
import comparator.service.validation.ProductionYearRange;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
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
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2, max = 50, message = "Brand name should be between 2 and 50 characters")
    @NotBlank(message = "Brand name cannot be empty")
    private String brand;

    @Size(min = 2, max = 50, message = "Model name should be between 2 and 50 characters")
    @NotBlank(message = "Model name cannot be empty")
    private String model;

    @ProductionYearRange(message = "Invalid production year, should be between {minProductionYear} and current year")
    private int productionYear;

    /* We let rental companies to not specify the horsepower
    This is mostly used only for sports cars, as are other parameters
    */
    @PositiveOrZero(message = "Horsepower should be positive")
    private int horsepower;

    @PositiveOrZero(message = "Number of doors should be positive")
    private int doorsCount;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private TransmissionType transmissionType;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vehicle_details", referencedColumnName = "id")
    private VehicleDetails vehicleDetails;

    @ManyToOne
    @JoinColumn(name = "id_rental")
    private Rental rental;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return getId() == vehicle.getId() && getProductionYear() == vehicle.getProductionYear() && getHorsepower() == vehicle.getHorsepower() && getDoorsCount() == vehicle.getDoorsCount() && Objects.equals(getBrand(), vehicle.getBrand()) && Objects.equals(getModel(), vehicle.getModel()) && getTransmissionType() == vehicle.getTransmissionType() && getVehicleType() == vehicle.getVehicleType() && Objects.equals(getVehicleDetails(), vehicle.getVehicleDetails()) && Objects.equals(getRental(), vehicle.getRental());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getProductionYear(), getHorsepower(), getDoorsCount(), getTransmissionType(), getVehicleType(), getVehicleDetails(), getRental());
    }
}