package comparator.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String brand;
    private String model;
    private int horsepower;
    private int doorsCount;
    private int productionYear;
    @Enumerated(EnumType.STRING)
    private TransmissionType transmissionType;
}