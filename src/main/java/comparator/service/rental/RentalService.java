package comparator.service.rental;

import comparator.model.Rental;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentalService {

    List<Rental> getAllRentals();

    Rental getRentalById(long id);
}