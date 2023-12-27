package co.in.airbnb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "locations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;

    private String street;
    private String city;
    private String pinCode;
    private Double latitude;
    private Double longitude;

//    @OneToOne(mappedBy = "location")
//    private Property property;
}
