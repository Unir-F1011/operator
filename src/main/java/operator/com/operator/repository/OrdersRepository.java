package operator.com.operator.repository;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import operator.com.operator.models.entities.Orders;

@Repository
@RequiredArgsConstructor
public class OrdersRepository {
    private final OrderJpaRepository repository;

    public Orders save(Orders orders) {
        return repository.save(orders);
    }

}
