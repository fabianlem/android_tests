package com.example.testapp;
import java.util.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.CharBuffer;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class test{
	//private final
	public static void main (String args[]){
		int min = 10;
		int max = 75;
		int NUM_ELEMENTS = 20;
		int numBeacons = 4;


		Random rand = new Random();
		ArrayList<Integer> list = new ArrayList();
		int randomNum = -1;
		for( int i =0; i < NUM_ELEMENTS; i++){
			randomNum = rand.nextInt((max - min) + 1) + min;
			list.add(randomNum);
		}
		for(int el : list)
			System.out.printf("%d ",el);

		//Search for consecutive numbers from a list of numbers.
		// Collections.sort(list, new Comparator<Integer>(){
		// 	@Override
		// 	public int compareTo(int one, int two){
		// 		return one.compareTo(two);
		// 	}
		// });
		Collections.sort(list);
		System.out.println("");
		for(int el : list)
			System.out.printf("%d ",el);
		int count = 0;

		boolean stElemFL = true;
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int el : list){
			if(count == numBeacons)
				break;

			if(stElemFL){
				res.add(el);
				stElemFL = false;
				count++;
				continue;
			}

			if(el == res.get(count-1))
				continue;

			if(el == res.get(count-1) + 1){
				res.add(el);
				count++;
			}

			else{
				res = new ArrayList<Integer>();
				stElemFL = true;
				count = 0;
			}
		}

		System.out.print("\n\nResulting sequence:\n");
		for(int el : res)
			System.out.printf("%d ",el);
		System.out.println("");
		//test connection to the server

		//String url ="http://172.17.130.250:8080/signup" ;
		String urlpost = "http://172.17.130.250:8080/userModel";
		String urlget = "http://172.17.130.250:8080/login/userModel/bohr/lol";
		String urlgt = "http://172.17.130.250:8080/login/userModel/bond/secret";
		String urlput = "http://172.17.130.250:8080/changeInfo/userModel/bolb/pass"; 
		
		String url4 = "http://172.17.130.250:8080/registerId/userModel/bond/secret";
		
		String url = "http://172.17.130.250:8080/changeInfo/userModel/";
		String url1 ="http://172.17.130.250:8080/test/tripModel/crap1/crap2";
		String url2 ="http://149.63.92.183:8080/androidLogic/tripModel/bohr/lol";
		String url3 ="http://192.168.1.4.1:8080/serverLogic/tripModel/joe/123abc";
		
		String bustest = "http://149.63.92.179:8080/getBusBeacons/busModel/1719/hello";

		
//		52532629
		getSample(bustest);
//		putSample(urlput);
		int i = 10;
		long start = System.nanoTime();
		while(i > 0){
		putSample(urlput, rand.nextInt((max - min) + 1) + min, rand.nextInt((max - min) + 1) + min );
		i--;
		}
		System.out.println("END Time:" + (float)(System.nanoTime() - start )/1e9);
//		HttpClient client = HttpClientBuilder.create().build();// DefaultHttpClient();
//		HttpGet getreq = new HttpGet(url);
//		HttpPut putreq = new HttpPut(url1);
//		putreq.addHeader("Accept", "application/json");
//        putreq.addHeader("Content-type", "application/json");
//        
//		InputStream in = null;
//		char[] buf = new char[8192];
//		try{
//			HttpResponse response = client.execute(putreq);
//			HttpEntity getRespEn = response.getEntity();
//			in = getRespEn.getContent();
//		
//			Reader reader = new InputStreamReader(in);
//			reader.read(buf);
//			for(int i = 0; i < buf.length;i++)
//				System.out.print(buf[i]);
//
//			
//	}catch(IOException e){
//			System.out.println(e.getMessage());
//		}
	}
	public static void getSample(String url){
		System.out.print("\n\nREST get sample:\n");

		HttpClient client = HttpClientBuilder.create().build();// DefaultHttpClient();
		HttpGet getreq = new HttpGet(url);
		
		InputStream in = null;
		char[] buf = new char[8192];
		try{
			HttpResponse response = client.execute(getreq);
			HttpEntity getRespEn = response.getEntity();
			in = getRespEn.getContent();
		
			Reader reader = new InputStreamReader(in);
			reader.read(buf);
			for(int i = 0; i < buf.length;i++)
				System.out.print(buf[i]);

			
	}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void putSample(String url, int major, int minor){
		System.out.print("\n\nREST put sample:\n");

		HttpClient client = HttpClientBuilder.create().build();// DefaultHttpClient();
		HttpPut putreq = new HttpPut(url);
		putreq.addHeader("Accept", "application/json");
        putreq.addHeader("Content-type", "application/json");

        String json = "{\"userId\":66565}";
		String strToPut = ("{\"major\":\"" +  777 + "\", \"minor\":\"" + 333
			         + "\", \"rssi\":\"" + 123  + "\", \"accuracy\":\"" + 98 + "\"}" );
//		JSONObject beacon = new JSONObject(strToPut);
		String lati = "\"latitude\":\"" + 32.837842 + "\"";
//	        		lon = new JSONObject("{\"longitude\":\"" + a.getLongitude() + "\"}");
	    String longi = "\"longitude\":\"" + -117.161084 + "\"";
		String input = "{\"beacons\":" + "[" + strToPut + "]"+ "," + lati + "," + longi +   "}";
//		System.out.println(input);
		
		JSONObject info = new JSONObject();
        JSONObject beacon = new JSONObject();
        JSONArray array = new JSONArray();
      
        info.put("longitude", "-117.161084");
        info.put("latitude", "32.837842");
        beacon.put("major", major);
        beacon.put("minor", minor);
        beacon.put("accuracy", "98");
        beacon.put("rssi", "123");
        array.add(beacon);
        info.put("beacons", array);
//        System.out.println(info.toString());
		
		InputStream in = null;
		char[] buf = new char[8192];
		try{
			System.out.println(info.toString());
			StringEntity se = new StringEntity(info.toString());
			putreq.setEntity(se);
			HttpResponse response = client.execute(putreq);
			HttpEntity getRespEn = response.getEntity();
			in = getRespEn.getContent();
		
			Reader reader = new InputStreamReader(in);
			reader.read(buf);
			for(int i = 0; i < buf.length;i++)
				System.out.print(buf[i]);

			
	}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void postSample(String url){

		System.out.print("\n\nREST post sample:\n");

		HttpClient client = HttpClientBuilder.create().build();// DefaultHttpClient();
		HttpPost postreq = new HttpPost(url);
		//postreq.addHeader("Accept", "application/json");
        postreq.addHeader("Content-type", "application/json");
        String json = "{\"userId\": 007,\"userName\":\"bond\",\"password\":\"james\",\"beacon\":[{\"major\": \"00\",\"minor\":\"11\"},{\"major\": \"22\",\"minor\":\"33\"}]}";
        JSONObject info = new JSONObject();
        JSONObject beacon = new JSONObject();
        JSONArray array = new JSONArray();
        Map<String, Object> m1 = new HashMap<String, Object>();
        
        info.put("userId", 007);
        info.put("userName", "bond");
        info.put("password", "secret");
        beacon.put("major",00);
        beacon.put("minor",11);
        array.add(beacon);
        info.put("beacon", array);
		InputStream in = null;
		char[] buf = new char[8192];
		System.out.println(info.toString());
		System.out.println(info.toJSONString());
//		try{
//			StringEntity se = new StringEntity(info.toJSONString());
//			postreq.setEntity(se);
//			HttpResponse response = client.execute(postreq);
//			HttpEntity getRespEn = response.getEntity();
//			in = getRespEn.getContent();
//		
//			Reader reader = new InputStreamReader(in);
//			reader.read(buf);
//			for(int i = 0; i < buf.length;i++)
//				System.out.print(buf[i]);
//
//			
//	}catch(IOException e){
//			System.out.println(e.getMessage());
//		}

	}
}