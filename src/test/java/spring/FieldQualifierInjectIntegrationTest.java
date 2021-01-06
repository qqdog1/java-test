package spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import spring.component.AnotherArbitraryDependency;
import spring.component.ArbitraryDependency;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
  loader=AnnotationConfigContextLoader.class,
  classes= {ArbitraryDependency.class, AnotherArbitraryDependency.class})
public class FieldQualifierInjectIntegrationTest {

    @Inject
    private AnotherArbitraryDependency anotherArbitraryDependency;

    @Inject
    @Qualifier("arbitraryDependency")
    private ArbitraryDependency arbitraryDependency;

    @Test
    public void givenInjectQualifier_WhenOnField_ThenDefaultFileValid(){
        assertNotNull(arbitraryDependency);
        assertEquals("Arbitrary Dependency",
        		arbitraryDependency.toString());
    }

    @Test
    public void givenInjectQualifier_WhenOnField_ThenNamedFileValid(){
        assertNotNull(anotherArbitraryDependency);
        assertEquals("Another Arbitrary Dependency",
        		anotherArbitraryDependency.toString());
    }
}
