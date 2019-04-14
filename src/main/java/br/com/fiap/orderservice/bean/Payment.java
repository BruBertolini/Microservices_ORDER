package br.com.fiap.orderservice.bean;

import lombok.*;
import io.swagger.annotations.ApiModelProperty;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @ApiModelProperty(notes = "Payment ID")
    private int id;
    
    @ApiModelProperty(notes = "Card number", required="true")
    private String cardNumber;
    
    @ApiModelProperty(notes = "Card expiration date", required="true")
    private String expireDate;
    
    @ApiModelProperty(notes = "Card operator (Visa, Master, etc)", required="true")
    private String operator;
}
