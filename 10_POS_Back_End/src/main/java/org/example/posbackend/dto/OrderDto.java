package org.example.posbackend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    @NotNull
    private String orderID;

    private String date;

    private String customerID;
    private List<OrderDetailDto> orderDetailDTOList;

}
