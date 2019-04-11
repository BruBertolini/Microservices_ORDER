package br.com.fiap.orderservice.bean;

import lombok.*;

import java.util.List;
import java.math.BigDecimal;
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
 @ApiModelProperty(notes = "The database generated Order ID")
    private int id;
    @ApiModelProperty( notes = "User E-mail", required = true)
    private String email;
	
    private String fullName;
	
    @ApiModelProperty( notes = "The order delivery address", required = true)
    private String shippingAddress;
	
    private List<Item> items;
	
    @ApiModelProperty( notes = "The order total amount", required = true)
    private BigDecimal total;
	
    private Payment payment;
    private String date;
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
