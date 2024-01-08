package comparator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2, max = 50, message = "City name should be between 2 and 50 characters")
    private String city;

    @Pattern(regexp = "^\\d{2}-\\d{3}$", message = "Invalid zip code format")
    private String zipCode;

    public Location() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return getId() == location.getId() && Objects.equals(getCity(), location.getCity()) && Objects.equals(getZipCode(), location.getZipCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCity(), getZipCode());
    }
}