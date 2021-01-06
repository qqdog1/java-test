package spring.component;

import org.springframework.stereotype.Component;

@Component(value="arbitraryDependency")
public class ArbitraryDependency {

    private final String label = "Arbitrary Dependency";

    public String toString() {
        return label;
    }
}
