package test.jmx.jolokia;

import java.util.Map;

import org.jolokia.client.*;
import org.jolokia.client.request.*;

public class JolokiaDemo {
    
    public static void main(String[] args) throws Exception {
        J4pClient j4pClient = new J4pClient("http://192.168.125.128:8080/jolokia-war-1.3.1");
        J4pReadRequest req = new J4pReadRequest("java.lang:type=Memory", "HeapMemoryUsage");
        J4pReadResponse resp = j4pClient.execute(req);
        Map<String,Long> vals = resp.getValue();
        long used = vals.get("used");
        long max = vals.get("max");
        int usage = (int) (used * 100 / max);
        System.out.println("Memory usage: used: " + used + 
                           " / max: " + max + " = " + usage + "%");
    }
}
