package com.megshan.springtransactionsdemo.data;

import com.megshan.springtransactionsdemo.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
