package operator.com.operator.controller;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@Slf4j
public class OperatorAPI {

    private final InnerOperator operator;

    @PostMapping("/v1/orders")
    public ResponseEntity<Orders> makeOrder(@Valid @RequestBody  OrdersDto provider) {
        try {
            Orders orders = operator.createOrder(provider);
            if (orders != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(orders);
            }
            return ResponseEntity.badRequest().build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/v1/items/{itemId}")
    public ResponseEntity<Object> deleteItem(@PathVariable String itemId) {
        try {
            operator.deleteItem(itemId);
            HashMap <String, String> response = new HashMap<>();
            response.put("message", "Item was deleted!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        }catch (IllegalArgumentException i) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    @PostMapping("/v1/shipments")
    public ResponseEntity<Shipments> sendShipment(@Valid @RequestBody ShipmentsDto shipment) {
        try {
            Shipments ship = operator.createShipments(shipment);
            return ResponseEntity.status(HttpStatus.CREATED).body(ship);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

}
