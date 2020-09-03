package test.json;

import java.text.DecimalFormat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class DoubleString {
	public static void main(String[] s) {
		new DoubleString();
	}

	private DoubleString() {
		double d = 0.00001;
        System.out.println(d);

        ObjectNode node = new ObjectMapper().createObjectNode();
        node.put("d", d);
        System.out.println(node.get("d").asDouble());
        
        DecimalFormat df = new DecimalFormat("##.##########");
        System.out.println(df.format(d));
	}
}
