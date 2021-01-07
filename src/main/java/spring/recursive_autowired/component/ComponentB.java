package spring.recursive_autowired.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentB {
	@Autowired
	private ComponentA a;
	
	public void printA() {
		a.printA();
	}
	
	public void printB() {
		System.out.println("BBB");
	}
}
