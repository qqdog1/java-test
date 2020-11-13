package interview.engine;

import interview.engine.vo.Order;

public class OrderContainerTest {
	private double[][] orderValue = 
		{{8000d, 0.1}, 
		 {8000d, 0.2},
		 {8000d, 0.3},
		 {8000d, 0.4},
		 {8000d, 0.5},
		 {8001, 0.8}
		};

	public static void main(String[] args) {
		new OrderContainerTest();
	}
	
	private OrderContainerTest() {
		OrderContainer container = new OrderContainer("BUY");
		
		createOrders(container);
		
		container.print();
		
		container.delete("3");
		
		container.print();
		
		
	}
	
	private void createOrders(OrderContainer container) {
		int id = 0;
		for(double[] values : orderValue) {
			Order order = new Order(String.valueOf(id++), "BTC_USD", values[0], values[1]);
			container.insert(order);
		}
	}
}
