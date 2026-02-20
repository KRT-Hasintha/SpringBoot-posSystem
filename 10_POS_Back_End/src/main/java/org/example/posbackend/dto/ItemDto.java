package org.example.posbackend.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ItemDto {

    @NotBlank(message = "Item id is mandatory")
    private String id;

    @NotBlank(message = "Item name is mandatory")
    private String name;

    @Positive(message = "Price must be greater than 0")
    private double price;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;
}

