package br.com.fiap.orderservice.bean;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private int id;
    private String cardNumber;
    private String expireDate;
    private String operator;
}
