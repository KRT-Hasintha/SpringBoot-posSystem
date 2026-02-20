package org.example.posbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    @NotNull(message = "Customer Id id mandatory")
    private String id;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "Customer name is incorrect")
    private String name;

    @Size(min = 10, max = 50, message = "min= 10 and max = 50")
    private String address;

}
