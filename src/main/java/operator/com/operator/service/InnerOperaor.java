package operator.com.operator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import operator.com.operator.models.dto.ItemsDto;
import operator.com.operator.models.dto.OrdersDto;
import operator.com.operator.models.dto.ShipmentsDto;
import operator.com.operator.models.entities.Orders;
import operator.com.operator.models.entities.Shipments;
import operator.com.operator.repository.OrdersRepository;
import operator.com.operator.repository.ShipmentRepository;

public interface InnerOperaor {
    Orders createOrder(OrdersDto order);

    Orders deleteItem(String itemId);

    Shipments createShipments(ShipmentsDto shipment);

}

@Service
@Slf4j
class Operator implements InnerOperaor {

    @Autowired
    private OrdersRepository orderRepo;

    @Autowired
    private ShipmentRepository shipRepo;

    @Override
    public Orders createOrder(OrdersDto order) {

        if (order != null &&
                StringUtils.hasLength(order.getCategory().trim()) &&
                StringUtils.hasLength(order.getColor().trim()) &&
                StringUtils.hasLength(order.getEmail().trim()) &&
                StringUtils.hasLength(order.getManufacturer().trim()) &&
                StringUtils.hasLength(order.getTel().trim()) &&
                StringUtils.hasLength(order.getProduct().trim()) &&
                order.getPrice() != null && order.getTel() != null &&
                StringUtils.hasLength(order.getName().trim())

        ) {
            Orders or = Orders.builder().name(order.getName()).category(order.getCategory())
                    .manufacturer(order.getManufacturer()).color(order.getColor()).tel(order.getTel())
                    .price(order.getPrice()).total(order.getTotal()).product(order.getProduct())
                    .email(order.getEmail()).build();

            orderRepo.save(or);

            // Enviar a elasticsearch
            ItemsDto item = ItemsDto.builder().category(order.getCategory())
                    .manufacturer(order.getManufacturer()).color(order.getColor())
                    .price(order.getPrice()).total(order.getTotal()).product(order.getProduct())
                    .build();

            log.info("{}", item);

            return or;
        }

        return null;
    }

    @Override
    public Orders deleteItem(String itemId) {
        return new Orders(null, itemId, itemId, itemId, null, itemId, null, itemId, itemId, itemId);
    }

    @Override
    public Shipments createShipments(ShipmentsDto shipment) {
        return new Shipments(null, null, null, null, null, null, null, null, null);
    }
}