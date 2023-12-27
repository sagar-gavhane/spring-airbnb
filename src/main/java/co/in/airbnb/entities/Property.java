package co.in.airbnb.entities;

import co.in.airbnb.enums.PropertyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "properties")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propertyId;

    private String title;
    private String description;
    private PropertyType type;
    private Integer maxNoOfGuestsAllowed;
    private Integer noOfBeds;
    private Integer noOfBathrooms;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToOne
    @JoinColumn(name = "host_id")
    private Host host;

    @OneToMany(mappedBy = "property")
    private List<Amenity> amenities;
}
