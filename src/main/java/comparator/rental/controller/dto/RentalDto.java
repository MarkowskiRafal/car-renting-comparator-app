package comparator.rental.controller.dto;

import comparator.rental.branch.model.RentalBranch;
import comparator.vehicle.model.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RentalDto {

    private String name;
    private List<Vehicle> vehicles;
    private List<RentalBranch> rentalBranches;
}