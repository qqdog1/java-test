package spring.recursive_autowired.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentA {
	@Autowired
	private ComponentB b;
	
	public void printA() {
		System.out.println("AAA");
	}
	
	public void printB() {
		b.printB();
	}
}
