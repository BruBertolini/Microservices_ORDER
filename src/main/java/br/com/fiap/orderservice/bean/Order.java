package br.com.fiap.orderservice.bean;

import lombok.*;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.math.BigDecimal;
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
    @ApiModelProperty(notes = "Order ID")
    private int id;
	
    @ApiModelProperty( notes = "Current user e-mail", required = true)
    private String email;

    @ApiModelProperty( notes = "Current user name", required = true)
    private String fullName;
	
    @ApiModelProperty( notes = "Order delivery address", required = true)
    private String shippingAddress;
	
    @ApiModelProperty( notes = "List of itens from order", required = true)
    private List<Item> items;
	
    @ApiModelProperty( notes = "Order total amount", required = true)
    private BigDecimal total;
	
    @ApiModelProperty( notes = "Payment information", required = true)
    private Payment payment;
 
    @ApiModelProperty( notes = "Order's date")
    private String date;
	
     @ApiModelProperty( notes = "Order's current status"
    private String status;
		       
    public Order(int id) { this.id = id; }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
    
    
    
}
