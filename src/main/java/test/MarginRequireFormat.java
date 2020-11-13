package test;

public class MarginRequireFormat {
	// 這邊的資訊要自己去組
	// 新單價格
	private static double NEW_ORDER_PRICE = 12345.67;
	// 新單量(contract) 賣單請帶負號
	private static double NEW_ORDER_SIZE = 2000;
	// 已開倉均價
	private static double OPEN_ORDER_PRICE = 10000;
	// 已開倉量(contract) 賣單請帶負號
	private static double OPEN_ORDER_SIZE = 99;
	// 已下單未成交買單均價
	private static double PENDING_BUY_ORDER_PRICE = 0;
	// 已下單未成交買單量(contract)
	private static double PENDING_BUY_ORDER_SIZE = 0;
	// 已下單未成交賣單均價
	private static double PENDING_SELL_ORDER_PRICE = 0;
	// 已下單未成交賣單量(contract) 一定要帶負號
	private static double PENDING_SELL_ORDER_SIZE = 0;
	// leverage
	private static double LEVERAGE = 100;
	
	// settings.config
	// contract size, by market, BTC = 0.001
	private static double CONTRACT_SIZE = 0.001;
	// initial margin
	private static double INITIAL_MARGIN = 0.01;
	// margin increment
	private static double MARGIN_INCREMENT = 0.005;
	// margin step
	private static double MARGIN_STEP = 100000;
	
	// others
	// fee rate, see web side
	private static double TAKER_FEE = 0.0006;
	
	public static void main(String[] s) {
		MarginRequireFormat format = new MarginRequireFormat();
		format.calc();
	}

	private MarginRequireFormat() {}
	
	private void calc() {
		// 計算全部包含新單所需的margin
		double totalMargin = getTotalMargin();
		
		// 計算現有不包含新單的margin
		double openMargin = getOpenMargin();
		
		// 全部 - 已開單 = 本次新單
		double newOrderMargin = totalMargin - openMargin;
		System.out.println("New order margin: " + newOrderMargin);
	}
	
	private double getTotalMargin() {
		System.out.println("Calculate Total Margin");
		double avgPrice = getAllOrderAveragePrice();
		double totalSize = getAllOrderSize();
		System.out.println("All order average price : " + avgPrice);
		System.out.println("All order size : " + totalSize);
		System.out.println("");
		
		double minInitMarginPercentage = getMinInitMarginPercentage(true);
		
		double initMargin = Math.abs((avgPrice * totalSize * CONTRACT_SIZE) * minInitMarginPercentage);
		double fee = Math.abs((avgPrice * totalSize * CONTRACT_SIZE) * TAKER_FEE * 2);
		double margin = initMargin + fee;
		System.out.println("Current margin : " + margin);
		System.out.println("");
		
		
		// pending買大於賣
		if(totalSize > 0) {
			double rate = Math.max((totalSize - OPEN_ORDER_SIZE), 0) / totalSize;
			System.out.println("Unknown rate : " + rate);
			margin = margin * rate;
			System.out.println("Pending order size > 0, multiple with rate.");
			System.out.println("Current margin : " + margin);
			System.out.println("");
		}
		System.out.println("Total margin : " + margin);
		System.out.println("=========================");
		return margin;
	}
	
	private double getOpenMargin() {
		System.out.println("Calculate Open Margin");
		double avgPendingPrice = getAveragePendingOrderPrice();
		double pendingSize = getPendingOrderSize();
		System.out.println("Average pending order price : " + avgPendingPrice);
		System.out.println("Pengind order size : " + pendingSize);
		System.out.println("");
		
		double minInitMarginPercentage = getMinInitMarginPercentage(true);
		
		double initMargin = Math.abs((avgPendingPrice * pendingSize * CONTRACT_SIZE) * minInitMarginPercentage);
		double fee = Math.abs((avgPendingPrice * pendingSize * CONTRACT_SIZE) * TAKER_FEE * 2);
		double margin = initMargin + fee;
		System.out.println("Current margin : " + margin);
		System.out.println("");
		
		
		// pending買大於賣
		if(pendingSize > 0) {
			double rate = Math.max((pendingSize - OPEN_ORDER_SIZE), 0) / pendingSize;
			System.out.println("Unknown rate : " + rate);
			margin = margin * rate;
			System.out.println("Pending order size > 0, multiple with rate.");
			System.out.println("Current margin : " + margin);
			System.out.println("");
		}
		System.out.println("Open margin : " + margin);
		System.out.println("=========================");
		return margin;
	}
	
	private double getMinInitMarginPercentage(boolean isContainNewOrder) {
		double maxPotentialPosition = getMAXPotentialPosition(isContainNewOrder);
		
		double marginPercentage = (((maxPotentialPosition - 1) / MARGIN_STEP) * MARGIN_INCREMENT) + INITIAL_MARGIN;
		System.out.println("Margin percentage : " + marginPercentage);
		System.out.println("====================================");
		System.out.println("");
		System.out.println("");
		return marginPercentage;
	}
	
	private double getMAXPotentialPosition(boolean isContainNewOrder) {
		if(isContainNewOrder) {
			System.out.println("NEW_ORDER_SIZE : " + NEW_ORDER_SIZE);
		}
		System.out.println("OPEN_ORDER_SIZE : " + OPEN_ORDER_SIZE);
		System.out.println("PENDING_BUY_ORDER_SIZE : " + PENDING_BUY_ORDER_SIZE);
		System.out.println("PENDING_SELL_ORDER_SIZE : " + PENDING_SELL_ORDER_SIZE);
		
		
		double buyPosition;
		if(isContainNewOrder && NEW_ORDER_SIZE > 0) {
			buyPosition = Math.abs(NEW_ORDER_SIZE + OPEN_ORDER_SIZE + PENDING_BUY_ORDER_SIZE);
			System.out.println("Buy position = NEW_ORDER_SIZE + OPEN_ORDER_SIZE + PENDING_BUY_ORDER_SIZE");
		} else {
			buyPosition = Math.abs(OPEN_ORDER_SIZE + PENDING_BUY_ORDER_SIZE);
			System.out.println("Buy position = OPEN_ORDER_SIZE + PENDING_BUY_ORDER_SIZE");
		}
		System.out.println("Buy position : " + buyPosition);

		
		double sellPosition;
		if(isContainNewOrder && NEW_ORDER_SIZE < 0) {
			sellPosition = Math.abs(NEW_ORDER_SIZE + OPEN_ORDER_SIZE + PENDING_SELL_ORDER_SIZE);
			System.out.println("Sell position = NEW_ORDER_SIZE + OPEN_ORDER_SIZE + PENDING_SELL_ORDER_SIZE");
		} else {
			sellPosition = Math.abs(OPEN_ORDER_SIZE + PENDING_SELL_ORDER_SIZE);
			System.out.println("Sell position = OPEN_ORDER_SIZE + PENDING_SELL_ORDER_SIZE");
		}
		System.out.println("Sell position : " + sellPosition);
		
		
		double maxPotentialPosition = Math.max(buyPosition, sellPosition);
		System.out.println("MAX potential position = Math.max(buyPosition, sellPosition)");
		System.out.println("MAX potential position : " + maxPotentialPosition);
		
		System.out.println("=================================");
		System.out.println("");
		System.out.println("");
		return maxPotentialPosition;
	}
	
	private double getAveragePendingOrderPrice() {
		Double avgPrice = ((PENDING_BUY_ORDER_PRICE * PENDING_BUY_ORDER_SIZE) + (PENDING_SELL_ORDER_PRICE * PENDING_SELL_ORDER_SIZE)) / (PENDING_BUY_ORDER_SIZE + PENDING_SELL_ORDER_SIZE);
		return Double.isNaN(avgPrice) ? 0 : avgPrice;
	}
	
	private double getPendingOrderSize() {
		return PENDING_BUY_ORDER_SIZE + PENDING_SELL_ORDER_SIZE;
	}
	
	private double getAllOrderAveragePrice() {
		return ((PENDING_BUY_ORDER_PRICE * PENDING_BUY_ORDER_SIZE) + (PENDING_SELL_ORDER_PRICE * PENDING_SELL_ORDER_SIZE) + (NEW_ORDER_PRICE * NEW_ORDER_SIZE)) /
		(PENDING_BUY_ORDER_SIZE + PENDING_SELL_ORDER_SIZE + NEW_ORDER_SIZE);
	}
	
	private double getAllOrderSize() {
		return PENDING_BUY_ORDER_SIZE + PENDING_SELL_ORDER_SIZE + NEW_ORDER_SIZE;
	}
}
