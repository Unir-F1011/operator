package operator.com.operator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import operator.com.operator.models.entities.Shipments;

interface ShipmentJpaRepository extends JpaRepository<Shipments, Long>, JpaSpecificationExecutor<Shipments> {
        
}
