package test;

public class DoubleIntTest {
	
	public static void main(String[] s) {
		new DoubleIntTest();
	}
	
	private DoubleIntTest() {
		int iCount = 100000;
		
		for(int i = 0 ; i < iCount ; i++) {
			publishTicksInt(System.currentTimeMillis(), 25, 24, 30, 24.5);
			publishTicksDouble(System.currentTimeMillis(), 25, 24, 30, 24.5);
		}
		
		//======================================================
		
		long lTime = System.nanoTime();
		for(int i = 0 ; i < iCount ; i++) {
			publishTicksInt(System.currentTimeMillis(), 25, 24, 30, 24.5);
		}
		lTime = System.nanoTime() - lTime;
		System.out.println(lTime);
		//==
		lTime = System.nanoTime();
		for(int i = 0 ; i < iCount ; i++) {
			publishTicksDouble(System.currentTimeMillis(), 25, 24, 30, 24.5);
		}
		lTime = System.nanoTime() - lTime;
		System.out.println(lTime);
	}
	
	private int calcAsInt(final double bidPrice, final double askPrice, final double avgPrice) {
        if (bidPrice == 0 || askPrice == 0 || avgPrice == 0) {
            return 0;
        } else if (bidPrice <= askPrice) {
            return 0;
        }
        return (int) (100 * (avgPrice - bidPrice) / (askPrice - bidPrice));
    }
	
	private double calcAsDouble(final double bidPrice, final double askPrice, final double avgPrice) {
        if (bidPrice == 0 || askPrice == 0 || avgPrice == 0) {
            return 0;
        } else if (bidPrice <= askPrice) {
            return 0;
        }
        return (avgPrice - bidPrice) / (askPrice - bidPrice);
    }
	
	private void publishTicksInt(final long timestampMillis, final double bid, final double ask, final long lastTotalVolume, final double lastAvgTradedPrice) {
        final int ratio = calcAsInt(bid, ask, lastAvgTradedPrice);
        if (ratio > 100) {
        } else if (ratio == 100) {
        }
        else if (ratio < 100 && ratio > 0) {
        } else if (ratio == 0) {
        } else {
        }
        
        double d = (100 - ratio)/100;
    }
	
	private void publishTicksDouble(final long timestampMillis, final double bid, final double ask, final long lastTotalVolume, final double lastAvgTradedPrice) {
        final double ratio = calcAsDouble(bid, ask, lastAvgTradedPrice);
        if (ratio > 1) {
        } else if (ratio == 1) {
        }
        else if (ratio < 1 && ratio > 0) {
        } else if (ratio == 0) {
        } else {
        }
        
        double d = 1-ratio;
    }
}
