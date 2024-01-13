package comparator.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2, max = 100, message = "Rental's name should be between 2 and 100 characters")
    @NotBlank(message = "Rental name cannot me empty")
    private String name;

    @OneToMany(mappedBy = "rental")
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private List<RentalBranch> rentalBranch;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return getId() == rental.getId() && Objects.equals(getName(), rental.getName()) && Objects.equals(getVehicles(), rental.getVehicles()) && Objects.equals(getRentalBranch(), rental.getRentalBranch());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getVehicles(), getRentalBranch());
    }
}