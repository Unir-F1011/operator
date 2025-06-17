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
public class ShipmentsDto {

    private String product;

    private String color;

    private String category;

    private Integer total;

    private String name;

    private String address;

    private Integer descount;

    private Integer payment;
}
