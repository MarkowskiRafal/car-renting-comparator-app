package comparator.rental.repository;

import comparator.rental.controller.dto.RentalDto;
import comparator.rental.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<RentalDto, Long> {

}