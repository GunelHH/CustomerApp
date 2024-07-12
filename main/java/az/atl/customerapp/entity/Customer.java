package az.atl.customerapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.function.Function;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="customers")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="name",nullable = false)
    String name;
    @Column(name="lastName",nullable = false)
    String lastName;
    @Column(name="email",nullable = false)
    @Email
    String email;
    @Column(name="country",nullable = false)
    String country;
}
