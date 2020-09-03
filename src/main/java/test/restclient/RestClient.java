package test.restclient;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestClient {
	private final OkHttpClient okHttpClient = new OkHttpClient.Builder().pingInterval(10, TimeUnit.SECONDS).build();
	private HttpUrl httpUrl;
	
	private static String DOMAIN = "http://uapp.oa.btse.io";
	private static String URL = "/v1/account";
	
	private static String API_KEY = "cb6c58089b020c780e4b52b15fe47220ea5fc967cfd0354c94d798420c2b6cce";
	private static String SECRET = "8dee318384bc26a456d074640c825f52cbc7e815379987925cb3d24204364c06";
	
	public static void main(String[] s) {
		new RestClient();
	}

	private RestClient() {
		httpUrl = HttpUrl.parse(DOMAIN);
		
		HttpUrl.Builder urlBuilder = httpUrl.newBuilder();
		urlBuilder.addPathSegments(URL);
		
		Request.Builder requestBuilder = new Request.Builder().url(urlBuilder.build().url().toString());
		
		String nonce = String.valueOf(System.currentTimeMillis());
		
		requestBuilder.addHeader("request-nonce", nonce);
		requestBuilder.addHeader("request-api", API_KEY);
		
		String sign = sign(URL, nonce, "");
		requestBuilder.addHeader("request-sign", sign);
		
		
//		requestBuilder.addHeader("Content-Type", "application/json");
		
		Request request = requestBuilder.get().build();
		try {
			Response response = okHttpClient.newCall(request).execute();
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String sign(String path, String nonce, String body) {
		StringBuilder sb = new StringBuilder();
		sb.append(path).append(nonce).append(body);
		
		byte[] hash = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_384, SECRET.getBytes()).doFinal(sb.toString().getBytes());
//		byte[] hash = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_384, sb.toString().getBytes()).doFinal(SECRET.getBytes());
		return Hex.encodeHexString(hash);
	}
}
