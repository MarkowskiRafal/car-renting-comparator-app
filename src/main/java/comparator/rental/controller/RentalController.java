package comparator.rental.controller;

import comparator.rental.controller.dto.RentalDto;
import comparator.rental.service.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RentalController {

    private static final String ROOT = "/rentals";

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping(ROOT)
    public ResponseEntity<List<RentalDto>> getRentals() {
        final List<RentalDto> rentals = rentalService.getAllRentals();
        return new ResponseEntity<>(rentals, HttpStatus.OK);
    }
}