package co.in.airbnb.controllers;

import co.in.airbnb.dto.PropertyListingRequestDto;
import co.in.airbnb.services.PropertyListingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property/listing")
public class PropertyListingController {
    private PropertyListingService propertyListingService;

    public PropertyListingController(PropertyListingService propertyListingService) {
        this.propertyListingService = propertyListingService;
    }

    @GetMapping
    public ResponseEntity<List<PropertyListingRequestDto>> getAllListedProperties() {
        List<PropertyListingRequestDto> listedProperties = propertyListingService.getAllListedProperties();
        return ResponseEntity.ok(listedProperties);
    }

    @GetMapping("{propertyId}")
    public ResponseEntity<PropertyListingRequestDto> getListedPropertyById(@PathVariable Integer propertyId) {
        PropertyListingRequestDto property = propertyListingService.getListedPropertyById(propertyId);
        return ResponseEntity.ok(property);
    }

    @PostMapping("/add")
    public ResponseEntity<PropertyListingRequestDto> addPropertyListing(@RequestBody PropertyListingRequestDto propertyListingRequestDto) {
        System.out.println(propertyListingRequestDto.getLocation());
        PropertyListingRequestDto savedPropertyListingRequestDto = propertyListingService.addPropertyListing(propertyListingRequestDto);
        return new ResponseEntity<>(savedPropertyListingRequestDto, HttpStatus.CREATED);
    }
}
