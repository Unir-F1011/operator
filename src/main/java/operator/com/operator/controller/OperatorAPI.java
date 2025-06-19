package operator.com.operator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import operator.com.operator.models.dto.OrdersDto;
import operator.com.operator.models.dto.ShipmentsDto;
import operator.com.operator.models.entities.Orders;
import operator.com.operator.models.entities.Shipments;
import operator.com.operator.service.InnerOperator;

@RestController
@RequiredArgsConstructor
@RequestMapping("/operator")
@Slf4j
public class OperatorAPI {

    private final InnerOperator operator;

    @PostMapping("/v1/orders")
    public ResponseEntity<Orders> makeOrder(@Valid @RequestBody  OrdersDto provider) {
        Orders orders = operator.createOrder(provider);
        if (orders != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(orders);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/v1/items/{itemId}")
    public ResponseEntity<Orders> deleteItem(@PathVariable String itemId) {
        operator.deleteItem(itemId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

    @PostMapping("/v1/shipments")
    public ResponseEntity<Shipments> sendShipment(@Valid @RequestBody ShipmentsDto shipment) {
        operator.createShipments(shipment);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

}
