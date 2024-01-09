package comparator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2, max = 50, message = "City name should be between 2 and 50 characters")
    @NotBlank(message = "City name cannot be empty")
    private String city;

    @Pattern(regexp = "^\\d{2}-\\d{3}$", message = "Invalid zip code format")
    private String zipCode;

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