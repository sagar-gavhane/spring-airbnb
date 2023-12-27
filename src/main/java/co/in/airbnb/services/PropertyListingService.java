package co.in.airbnb.services;

import co.in.airbnb.dto.PropertyListingRequestDto;
import co.in.airbnb.entities.Host;
import co.in.airbnb.entities.Location;
import co.in.airbnb.entities.Property;
import co.in.airbnb.repositories.AmenityRepository;
import co.in.airbnb.repositories.HostRepository;
import co.in.airbnb.repositories.LocationRepository;
import co.in.airbnb.repositories.PropertyRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyListingService {
    private PropertyRepository propertyRepository;
    private LocationRepository locationRepository;
    private HostRepository hostRepository;
    private AmenityRepository amenityRepository;
    private ModelMapper modelMapper;

    public PropertyListingService(
            PropertyRepository propertyRepository,
            LocationRepository locationRepository,
            HostRepository hostRepository,
            AmenityRepository amenityRepository,
            ModelMapper modelMapper) {
        this.propertyRepository = propertyRepository;
        this.locationRepository = locationRepository;
        this.hostRepository = hostRepository;
        this.amenityRepository = amenityRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public PropertyListingRequestDto addPropertyListing(PropertyListingRequestDto propertyListingRequestDto) {
        Host host = hostRepository.findById(1).orElseThrow(() -> new IllegalArgumentException("host doesnt exists"));

        Location location = modelMapper.map(propertyListingRequestDto.getLocation(), Location.class);
        Property property = modelMapper.map(propertyListingRequestDto, Property.class);

        System.out.println(property.getAmenities());
        property.setAmenities(null);
        Location savedLocation = locationRepository.save(location);
        //List<Amenity> savedAmenities = amenityRepository.saveAll(property.getAmenities());

        property.setLocation(savedLocation);
        property.setHost(host);
        //property.setAmenities(savedAmenities);

        Property savedProperty = propertyRepository.save(property);
        return modelMapper.map(savedProperty, PropertyListingRequestDto.class);
    }

    public List<PropertyListingRequestDto> getAllListedProperties() {
        List<Property> properties = propertyRepository.findAll();
        List<PropertyListingRequestDto> propertyListingRequestDtos = new ArrayList<>();

        for (Property property : properties) {
            PropertyListingRequestDto propertyListingRequestDto = modelMapper.map(property, PropertyListingRequestDto.class);
            propertyListingRequestDtos.add(propertyListingRequestDto);
        }

        return propertyListingRequestDtos;
    }

    public PropertyListingRequestDto getListedPropertyById(Integer propertyId) {
        Property property = propertyRepository
                .findById(propertyId)
                .orElseThrow(() -> new IllegalArgumentException("Property is invalid."));

        return modelMapper.map(property, PropertyListingRequestDto.class);
    }
}
