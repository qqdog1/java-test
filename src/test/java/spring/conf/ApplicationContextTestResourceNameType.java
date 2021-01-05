package spring.conf;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextTestResourceNameType {

    @Bean(name="namedFile")
    public File namedFile() {
        File namedFile = new File("namedFile.txt");
        return namedFile;
    }
    
//    @Bean(name="namedFile2")
//    public File namedFile2() {
//        File namedFile = new File("namedFile2.txt");
//        return namedFile;
//    }
}
