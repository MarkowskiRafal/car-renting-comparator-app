package comparator.rental.service;

import comparator.exception.ResourceNotFoundException;
import comparator.rental.controller.dto.RentalDto;
import comparator.rental.repository.RentalRepository;
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
    public List<RentalDto> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public RentalDto getRentalById(long id) throws ResourceNotFoundException {
        return rentalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rental by given id was not found"));
    }
}