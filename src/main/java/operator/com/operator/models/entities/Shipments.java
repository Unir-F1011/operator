package operator.com.operator.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;
import operator.com.operator.models.dto.ShipmentsDto;

@Entity
@Table(name = "shipments")
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Shipments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Log id; 

    @Column(name = "product")
    private String product;

    @Column(name = "color")
    private String color; 

    @Column(name = "category") 
    private String category; 

    @Column(name = "total")
    private Integer total;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address; 

    @Column(name = "descount")
    private Integer descount;

    @Column(name = "payment")
    private Integer payment;

    public void update(ShipmentsDto shipmentDto) {
        this.address = shipmentDto.getAddress();
        this.category = shipmentDto.getCategory();
        this.color = shipmentDto.getColor();
        this.descount = shipmentDto.getDescount();
        this.name = shipmentDto.getName();
        this.payment = shipmentDto.getPayment();
        this.total = shipmentDto.getTotal();
        this.product = shipmentDto.getProduct();
    }

}
