package operator.com.operator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import operator.com.operator.models.entities.Orders;

interface OrderJpaRepository extends JpaRepository<Orders, Long>, JpaSpecificationExecutor<Orders> {
    
}
