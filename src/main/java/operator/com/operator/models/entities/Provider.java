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
import operator.com.operator.models.dto.ProviderDto;

@Entity
@Table(name = "provider")
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
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


    public void update(ProviderDto provDto) {

    }


}