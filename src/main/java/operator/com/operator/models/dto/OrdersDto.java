package operator.com.operator.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrdersDto {

    private String product;

    private String color;

    private String category;

    private Integer price;

    private String manufacturer;

    private Integer total;

    private String name;

    private String email; 

    private String tel;
}
