package spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import spring.conf.ApplicationContextTestResourceNameType;

import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
  loader=AnnotationConfigContextLoader.class, 
  classes=ApplicationContextTestResourceNameType.class)
public class MatchByName {

    @Resource(name="namedFile")
    private File defaultFile;

    @Test
    public void givenResourceAnnotation_WhenOnField_ThenDependencyValid(){
        assertNotNull(defaultFile);
        assertEquals("namedFile.txt", defaultFile.getName());
    }
}
