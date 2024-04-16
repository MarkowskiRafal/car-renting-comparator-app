package comparator.rental.service;

import comparator.rental.controller.dto.RentalDto;
import comparator.rental.model.Rental;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentalService {

    List<RentalDto> getAllRentals();

    RentalDto getRentalById(long id);
}