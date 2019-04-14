package br.com.fiap.orderservice.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    
    @ApiModelProperty(notes = "Item ID")
    private int id;
    
    @ApiModelProperty(notes = "Item description")
    private String description;
 
    @ApiModelProperty(notes = "Item price")
    private BigDecimal price;
    
    @ApiModelProperty(notes = "Quatity itens")
    private BigDecimal quantity  = BigDecimal.ZERO;
}
