package spring.recursive_autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class ComponentA {
	@Autowired
	private ComponentB b;
	
	public void print() {
		System.out.println("AAA");
	}
}
