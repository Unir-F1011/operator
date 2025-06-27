package operator.com.operator.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import operator.com.operator.client.InnerRestClient;
import operator.com.operator.models.dto.ItemsDto;
import operator.com.operator.models.dto.OrdersDto;
import operator.com.operator.models.dto.ShipmentsDto;
import operator.com.operator.models.entities.Orders;
import operator.com.operator.models.entities.Shipments;
import operator.com.operator.repository.OrdersRepository;
import operator.com.operator.repository.ShipmentRepository;

public interface InnerOperator {
    Orders createOrder(OrdersDto order);

    void deleteItem(String itemId);

    Shipments createShipments(ShipmentsDto shipment);

}

@Service
@Slf4j
class Operator implements InnerOperator {
    @Value("${server.serviceUrl}")
    private String searchURL;

    @Autowired
    private OrdersRepository orderRepo;

    @Autowired
    private ShipmentRepository shipRepo;

    @Autowired
    private InnerRestClient client;

    @Override
    public Orders createOrder(OrdersDto order) {
        Orders or = Orders.builder()
                .name(order.getName().trim())
                .category(order.getCategory().trim())
                .manufacturer(order.getManufacturer().trim())
                .color(order.getColor().trim())
                .tel(order.getTel().trim())
                .price(order.getPrice())
                .total(order.getTotal())
                .product(order.getProduct().trim())
                .email(order.getEmail().trim())
                .build();

        try {
            Orders resp = orderRepo.save(or);

            // Enviar a micro search
            ItemsDto item = ItemsDto.builder()
                    .category(resp.getCategory())
                    .manufacturer(resp.getManufacturer())
                    .color(resp.getColor())
                    .price(resp.getPrice())
                    .total(resp.getTotal())
                    .product(resp.getProduct())
                    .build();

           this.client.doRequest(HttpMethod.POST, URI.create(this.searchURL), item);

        } catch (Exception e) {
            throw new RuntimeException("Internal error");
        }

        return or;
    }

    @Override
    public void deleteItem(String itemId) {
        if (StringUtils.hasLength(itemId.trim())) {
            try {
                this.client.doRequest(HttpMethod.DELETE, URI.create(String.format("{}/{}", this.searchURL, itemId.trim())), null);

            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Id not found");
            } catch (Exception e) {
                throw new RuntimeException("Internal error");
            }
        } else {
            throw new IllegalArgumentException("Empty id");
        }

    }

    @Override
    public Shipments createShipments(ShipmentsDto shipment) {
        Shipments ship = Shipments.builder()
                .address(shipment.getAddress().trim())
                .category(shipment.getCategory().trim())
                .color(shipment.getColor().trim())
                .payment(shipment.getPayment())
                .total(shipment.getTotal())
                .discount(shipment.getDiscount())
                .name(shipment.getName().trim())
                .product(shipment.getProduct().trim())
                .build();

        try {
            Shipments resp = this.shipRepo.save(ship);
            ItemsDto itemsDto = ItemsDto.builder()
                    .total(resp.getTotal())
                    .build();

            this.client.doRequest(HttpMethod.PATCH, URI.create(String.format("{}/{}", this.searchURL, resp.getId().trim())),itemsDto);

        } catch (Exception e) {
            throw new RuntimeException("Internal error");
        }

        return null;
    }
}