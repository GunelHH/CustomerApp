package az.atl.customerapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDto {
    Long id;
    @NotBlank
    String name;
    @NotBlank
    String lastName;
    @NotBlank
    String email;
    @NotBlank
    String country;
}
