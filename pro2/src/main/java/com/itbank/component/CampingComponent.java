package com.itbank.component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.itbank.util.ResultType;

@Component
public class CampingComponent {
	private String serviceKey = "VK%2FIrbQeozR6bw%2BzxsN%2FJL0VtbE0J9imnS7at3NjHjV2FYprJ1xBqc2X6JVHe2OHTlzA8gDcbDrxMf4seJyu0Q%3D%3D";
	
	public String getCampingList(HashMap<String, String> param) throws IOException {
		return getCampingList(ResultType.JSON, param);
	}

	public String getCampingList(ResultType resultType, HashMap<String, String> param) throws IOException {
		String jsonData = "";
		
		String urlString = "https://apis.data.go.kr/B551011/GoCamping/locationBasedList";
		urlString += "?";
		
		HashMap<String, String> params= new HashMap<>();
		params.put("serviceKey", serviceKey);
		params.put("numOfRows", "10");
		params.put("pageNo", "1");
		params.put("MobileOS", "ETC");
		params.put("MobileApp", "AppTest");
		params.put("mapX", param.get("mapX"));
		params.put("mapY", param.get("mapY"));
		params.put("radius", "2000");
		params.put("_type", resultType.getResultType());
		
		for(String key : params.keySet()) {
			String value = params.get(key);
			urlString += key + "=" + value + "&";
		}
		
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("content-type", "application/json;charset=utf-8");
		
		Scanner sc = null;
		int statusCode = conn.getResponseCode();
		if(200 <= statusCode && statusCode < 300) {
			sc = new Scanner(conn.getInputStream());
			while(sc.hasNextLine()) {
				jsonData += sc.nextLine();
			}
		}
		else {
			sc = new Scanner(conn.getErrorStream());
			while(sc.hasNextLine()) {
				System.err.println(sc.hasNextLine());
			}
		}
		conn.disconnect();
		sc.close();
		
		return jsonData;
	}
}
