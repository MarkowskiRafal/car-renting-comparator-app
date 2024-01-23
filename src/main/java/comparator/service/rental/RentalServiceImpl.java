package comparator.service.rental;

import comparator.exception.ResourceNotFoundException;
import comparator.model.Rental;
import comparator.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// todo delete this bad looking impl postfix - need to think about anything better
@Service
public class RentalServiceImpl implements RentalService {


    private final RentalRepository rentalRepository;

    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental getRentalById(long id) throws ResourceNotFoundException {
        return rentalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rental by given id was not found"));
    }


}