package spring.recursive_autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class ComponentB {
	@Autowired
	private ComponentA a;
	
	public void print() {
		a.print();
	}
}
