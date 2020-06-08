package test.enumTest;

public class InnerObject {
	private String name;
	private Level2 l2;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Level2 getL2() {
		return l2;
	}
	public void setL2(Level2 l2) {
		this.l2 = l2;
	}
}

class Level2 {
	private String l2;
	private int i2;
	public String getL2() {
		return l2;
	}
	public void setL2(String l2) {
		this.l2 = l2;
	}
	public int getI2() {
		return i2;
	}
	public void setI2(int i2) {
		this.i2 = i2;
	}
}