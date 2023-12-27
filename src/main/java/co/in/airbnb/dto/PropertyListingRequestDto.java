package co.in.airbnb.dto;

import co.in.airbnb.entities.Amenity;
import co.in.airbnb.entities.Host;
import co.in.airbnb.entities.Location;
import co.in.airbnb.enums.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyListingRequestDto {
    private Integer propertyId;
    private String title;
    private String description;
    private PropertyType type;
    private Integer maxNoOfGuestsAllowed;
    private Integer noOfBeds;
    private Integer noOfBathrooms;
    private Location location;
    private Host host;
    private List<Amenity> amenities;
}
