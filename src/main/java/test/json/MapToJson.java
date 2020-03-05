package test.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapToJson {
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private MapToJson() {
		OO o = create(5, new OO());
		String s;
		try {
			s = objectMapper.writeValueAsString(o);
			System.out.println(s);
			
			OO ooo = objectMapper.readValue(s, OO.class);
			System.out.println(ooo.getName());
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MapToJson();
	}
	
	public OO create(int layer, OO o) {
		OO oo = new OO();
		String name = String.valueOf(layer);
		oo.setName(name);
		if(layer > 0) {
			Map<String, OO> map = new HashMap<>();
			map.put(name, oo);
			o.setMap(map);
			layer--;
			create(layer, oo);
		} else {
			o.setMap(null);
		}
		return o;
	}
}
