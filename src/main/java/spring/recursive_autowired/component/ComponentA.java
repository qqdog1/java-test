package spring.recursive_autowired.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
public class ComponentA {
	@Autowired
	private ComponentB b;
	
	@GetMapping("/print")
	public void printB() {
		b.printB();
	}
	
	public void printA() {
		System.out.println("AAA");
	}
}
