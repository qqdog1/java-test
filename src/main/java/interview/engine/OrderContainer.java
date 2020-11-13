package interview.engine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentSkipListMap;

import interview.engine.vo.Order;

public class OrderContainer {
	private Map<BigDecimal, Queue<Order>> mapOrders = new HashMap<>();
	private Map<String, Order> mapClientOrderIdToOrder = new HashMap<>();

	private String side;
	
	public OrderContainer(String side) {
		this.side = side;
	}
	
	public void insert(Order order) {
		if(!mapOrders.containsKey(order.getPrice())) {
			mapOrders.put(order.getPrice(), new LinkedList<>());
		}
		mapOrders.get(order.getPrice()).add(order);
		mapClientOrderIdToOrder.put(order.getClientOrderId(), order);
	}
	
	public void delete(String clientOrderId) {
		Order order = mapClientOrderIdToOrder.get(clientOrderId);
		mapOrders.get(order.getPrice()).remove(order);
	}
	
	public void print() {
		System.out.println("Current orders :");
		for(BigDecimal price : mapOrders.keySet()) {
			System.out.println("===== " + price + " =====");
			for(Order order : mapOrders.get(price)) {
				System.out.println("ClientOrderId : " + order.getClientOrderId());
			}
		}
	}
}
