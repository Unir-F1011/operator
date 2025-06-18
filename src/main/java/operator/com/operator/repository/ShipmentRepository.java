package operator.com.operator.repository;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import operator.com.operator.models.entities.Shipments;

@Repository
@RequiredArgsConstructor
public class ShipmentRepository {
    private final ShipmentJpaRepository repository;

    public Shipments save(Shipments shipment) {
        return repository.save(shipment);
    }
}
