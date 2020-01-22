package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class PingRESTApi {
	private final OkHttpClient okHttpClient = new OkHttpClient.Builder().pingInterval(10, TimeUnit.SECONDS).build();
	
	private static List<String> lstUrl = new ArrayList<>();
	
	static {
		lstUrl.add("https://tech-linebot.herokuapp.com/");
		lstUrl.add("https://tech-backend.herokuapp.com/");
	}

	public static void main(String[] args) {
		new PingRESTApi().pingAll();
	}

	private PingRESTApi() {
	}
	
	public void pingAll() {
		for(String url : lstUrl) {
			ping(url);
		}
	}
	
	public void ping(String url) {
		HttpUrl httpUrl = HttpUrl.parse(url);
		HttpUrl.Builder urlBuilder = httpUrl.newBuilder();
		
		try {
			long timestamp = System.currentTimeMillis();
			sendSyncHttpGet(urlBuilder.build().url().toString());
			timestamp = System.currentTimeMillis() - timestamp;
			System.out.println(url + "  " + timestamp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String sendSyncHttpGet(String url) throws IOException {
		return okHttpClient.newCall(new Request.Builder().url(url).build()).execute().body().string();
	}
}
