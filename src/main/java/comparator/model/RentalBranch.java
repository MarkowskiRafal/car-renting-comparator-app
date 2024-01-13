package comparator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
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
public class RentalBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2, max = 100, message = "Street's name should be between 2 and 100 characters")
    @NotBlank(message = "Street name cannot me empty")
    private String streetName;

    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "id_rental")
    private Rental rental;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalBranch that = (RentalBranch) o;
        return getId() == that.getId() && Objects.equals(getStreetName(), that.getStreetName()) && Objects.equals(getLocation(), that.getLocation()) && Objects.equals(getRental(), that.getRental());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStreetName(), getLocation(), getRental());
    }
}