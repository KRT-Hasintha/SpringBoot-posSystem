package org.example.posbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@IdClass(OrderDetailPK.class)
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class OrderDetail {
    @Id
    private String orderID;
    @Id
    private String itemID;

    private int itemQty;
    private double unitPrice;
}
