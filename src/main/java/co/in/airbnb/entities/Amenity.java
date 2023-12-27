package co.in.airbnb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "amenities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer amenityId;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;
}
