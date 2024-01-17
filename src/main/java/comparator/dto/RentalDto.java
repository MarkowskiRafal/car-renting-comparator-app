package comparator.dto;

import comparator.model.RentalBranch;
import comparator.model.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RentalDto {

    private long id;
    private String name;
    private List<Vehicle> vehicles;
    private List<RentalBranch> rentalBranches;
}