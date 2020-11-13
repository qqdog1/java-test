package interview.engine.vo;

import java.math.BigDecimal;

public class Order {
	private String clientOrderId;
	private String symbol;
	private BigDecimal price;
	private BigDecimal qty;
	
	public Order(String clientOrderId, String symbol, double price, double qty) {
		this.clientOrderId = clientOrderId;
		this.symbol = symbol;
		this.price = BigDecimal.valueOf(price);
		this.qty = BigDecimal.valueOf(qty);
	}
	
	public String getClientOrderId() {
		return clientOrderId;
	}
	public void setClientOrderId(String clientOrderId) {
		this.clientOrderId = clientOrderId;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
}
