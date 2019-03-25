package br.com.fiap.orderservice.bean;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String description;
    private BigDecimal price;
    private BigDecimal quantity  = BigDecimal.ZERO;
}
