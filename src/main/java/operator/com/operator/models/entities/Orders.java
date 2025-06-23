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
import operator.com.operator.models.consts.Consts;

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
    @Column(name = Consts.ID, updatable = false, nullable = false)
    private UUID id;
    
    @Column(name = Consts.PRODUCT)
    private String product;

    @Column(name = Consts.COLOR)
    private String color; 

    @Column(name = Consts.CATEGORY) 
    private String category; 

    @Column(name = Consts.PRICE)
    private Integer price;

    @Column(name = Consts.MANUFACTURER)
    private String manufacturer;

    @Column(name = Consts.TOTAL)
    private Integer total;

    @Column(name = Consts.NAME)
    private String name;

    @Column(name = Consts.EMAIL)
    private String email;

    @Column(name = Consts.TEL)
    private String tel;
}