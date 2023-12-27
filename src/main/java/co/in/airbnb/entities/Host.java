package co.in.airbnb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "hosts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hostId;

    private String name;

    @Column(unique = true)
    private String email;

    private String phone;
    private String password;
    private Date joinedOn;
}
