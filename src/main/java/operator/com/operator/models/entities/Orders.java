package operator.com.operator.models.entities;

import java.util.UUID;

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
import operator.com.operator.models.dto.OrdersDto;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @Column(name = "product")
    private String product;

    @Column(name = "color")
    private String color; 

    @Column(name = "category") 
    private String category; 

    @Column(name = "price")
    private Integer price;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "total")
    private Integer total;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "tel")
    private String tel;


    public void update(OrdersDto provDto) {
        this.category = provDto.getCategory();
        this.color = provDto.getColor();
        this.email = provDto.getEmail();
        this.manufacturer = this.getManufacturer();
        this.name = this.getName();
        this.product = this.getProduct();
        this.tel = this.getTel();
        this.total = this.getTotal();
        this.price = this.getPrice(); 
    }


}