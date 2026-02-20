package org.example.posbackend.repository;

import org.example.posbackend.entity.OrderDetail;
import org.example.posbackend.entity.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
}
