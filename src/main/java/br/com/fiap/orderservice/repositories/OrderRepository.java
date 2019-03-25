package br.com.fiap.orderservice.repositories;

import br.com.fiap.orderservice.bean.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private List<Order> orders;

    public OrderRepository() {
        if (this.orders == null) {
            this.orders = new ArrayList<Order>();
        }
    }

    public boolean updateOrder(Order order) {
        int index = this.orders.indexOf(order);

        if (index == -1) {
            return false;
        }

        this.orders.set(index, order);
        return true;
    }


    public boolean deleteOrder(int id) {
        Order order = new Order(id);
        int index = this.orders.indexOf(order);

        if (index == -1) {
            return false;
        }

        this.orders.remove(index);
        return true;
    }


    public Order addOrder(Order order) {
        this.orders.add(order);
        return order;
    }

    public List<Order> getOrders() {
        return this.orders;
    }
}
