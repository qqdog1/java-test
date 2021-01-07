package spring.recursive_autowired.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/b")
public class ComponentB {
	@Autowired
	private ComponentA a;
	
	@GetMapping("/print")
	public void printA() {
		a.printA();
	}
	
	public void printB() {
		System.out.println("BBB");
	}
}
