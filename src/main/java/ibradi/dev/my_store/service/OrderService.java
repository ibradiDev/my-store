package ibradi.dev.my_store.service;


import ibradi.dev.my_store.model.Order;

import java.util.List;


public interface OrderService {
	Order addOrder(Order order, long customerId, long cartId);

	Order getOrderById(long orderId);

	Order updateOrder(Order order, long orderId);

	List<Order> getOrderByCustomerId(long customerId);

	List<Order> getAllOrders();

	//List<Order> getAllOrdersByCartId(long cartId);
	void deleteOrder(long orderId);

	Order addOrderItem(Order order, long customerId);
}