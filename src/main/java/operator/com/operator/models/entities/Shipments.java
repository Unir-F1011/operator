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
import operator.com.operator.models.consts.Consts;

@Entity
@Table(name = "shipments")
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Shipments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Consts.ID, updatable = false, nullable = false)
    private String id; 

    @Column(name = Consts.PRODUCT)
    private String product;

    @Column(name = Consts.COLOR)
    private String color; 

    @Column(name = Consts.CATEGORY) 
    private String category; 

    @Column(name = Consts.TOTAL)
    private Integer total;

    @Column(name = Consts.NAME)
    private String name;

    @Column(name = Consts.ADDRESS)
    private String address; 

    @Column(name = Consts.DISCAOUNT)
    private Integer discount;

    @Column(name = Consts.PAYMENT)
    private Integer payment;
}
