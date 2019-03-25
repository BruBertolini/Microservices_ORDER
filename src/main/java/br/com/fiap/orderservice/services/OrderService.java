package br.com.fiap.orderservice.services;

import br.com.fiap.orderservice.bean.Item;
import br.com.fiap.orderservice.bean.Order;
import br.com.fiap.orderservice.repositories.OrderRepository;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderService {

	private OrderRepository repo;

	public OrderService() {
		this.repo = new OrderRepository();
	}

	public Order save(Order order) {
		order.setId(this.repo.getOrders().size() + 1);

		order.setTotal(calculateTotal(order.getItems()));

		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		order.setDate(format.format(new Date()));
		order.setStatus("created");

		return this.repo.addOrder(order);
	}

	public boolean update(Order order) {

		Order orderCopy = new Order(order.getId());

		orderCopy.setTotal(this.calculateTotal(order.getItems()));
		orderCopy.setItems(order.getItems());
		orderCopy.setPayment(order.getPayment());
		orderCopy.setEmail(order.getEmail());
		orderCopy.setFullName(order.getFullName());
		orderCopy.setShippingAddress(order.getShippingAddress());

		return this.repo.updateOrder(order);
	}

	public boolean delete(int id) {
		if (this.getById(id).getClass() == Order.class) {
			this.repo.getOrders().remove(this.getById(id));
			return true;
		}

		return false;
	}

	public Order findById(int id) {
		int index = this.repo.getOrders().indexOf(new Order(id));

		if (index == -1) {
			return null;
		}

		return this.repo.getOrders().get(index);
	}

	public Order getById(int id) {
		for (Order order : this.repo.getOrders()) {
			if (order.getId() == id) {
				return order;
			}
		}
		return null;
	}

	private BigDecimal calculateTotal(List<Item> items) {
		BigDecimal precoTotal = BigDecimal.ZERO;

		for (Item item : items) {
			precoTotal.add(item.getQuantity().multiply(item.getPrice()));
		}

		return precoTotal;
	}
}
